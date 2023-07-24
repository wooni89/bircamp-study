package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import bitcamp.myapp.dao.BoardListDao;
import bitcamp.myapp.dao.MemberListDao;
import bitcamp.net.RequestEntity;
import bitcamp.net.ResponseEntity;


// 1. 클라이언트가 보낸 명령을 데이터 이름과 메서드 이름으로 분리한다.
public class ServerApp {

  int port;
  ServerSocket serverSocket;

  // 클라이언트 요청을 처리할 DAO 객체를 맵에 보관한다.

  HashMap<String, Object> daoMap = new HashMap<>();

  // 자바 스레드 풀 준비
  ExecutorService threadPool = Executors.newFixedThreadPool(10);

  public ServerApp(int port) throws Exception {

    this.port = port;
    daoMap.put("member", new MemberListDao("member.json"));
    daoMap.put("board", new BoardListDao("board.json"));
    daoMap.put("reading", new BoardListDao("reading.json"));

  }

  public void close() throws Exception {

    serverSocket.close();
  }

  public static void main(String[] args) throws Exception {

    if (args.length < 1) {
      System.out.println("실행 예) java ... bin/main bitcamp.myapp.ServerApp 포트번호");
      return;
    }
    ServerApp app = new ServerApp(Integer.parseInt(args[0]));

    app.execute();
    app.close();

  }

  public void execute() throws Exception {

    System.out.println("[MyList 서버 Application]");
    this.serverSocket = new ServerSocket(port);
    System.out.println("Server Runing");

    while (true) {
      Socket socket = serverSocket.accept();
      threadPool.execute(() -> processRequest(socket));
      
      // 컴파일러는 위의 문장을 다음과 같이 바꾼다.
      // class $1 implements Runnable {
      // ServerApp this$0;
      // Socket socket;
      //
      // public $1(ServerApp arg0, Socket arg1) {
      // this$0 = arg0;
      // socket = arg1;
      // }
      //
      // public void run() {
      // this$0.processRequest(socket);
      // }
      // }
      //
      // $1 obj = new $1(this, socket);
      // threadPool.execute(obj);
     
    }
  }

  public static Method findMethod(Object obj, String methodName) {
    Method[] methods = obj.getClass().getDeclaredMethods();
    for (int i = 0; i < methods.length; i++) {
      if (methods[i].getName().equals(methodName)) {
        return methods[i];
      }
    }
    return null;
  }

  public static Object call(Object obj, Method method, RequestEntity request) throws Exception {
    Parameter[] params = method.getParameters();
    if (params.length > 0) {
      return method.invoke(obj, request.getObject(params[0].getType()));
    } else {
      return method.invoke(obj);
    }
  }

  // 클라이언트와 접속이 이뤄지면 클라이언트의 요청을 처리한다.
  public void processRequest(Socket socket) {


    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
      System.out.printf("[%s]%s:%s 클라이언트가 접속하였습니다.\n", Thread.currentThread().getName(), 
          socketAddress.getHostString(),
          socketAddress.getPort());


      RequestEntity request = RequestEntity.fromJson(in.readUTF());

      String command = request.getCommand();
      System.out.println(command);

      String[] values = command.split("/");
      String dataName = values[0];
      String methodName = values[1];


      Object dao = daoMap.get(dataName);
      if (dao == null) {
        out.writeUTF(
            new ResponseEntity()
            .status(ResponseEntity.ERROR).result("데이터를 찾을 수 없습니다.").toJson());
        return;
      }

      Method method = findMethod(dao, methodName);

      if (method == null) {
        out.writeUTF(
            new ResponseEntity()
            .status(ResponseEntity.ERROR).result("메서드를 찾을 수 없습니다.").toJson());
        return;
      }

      try {
        Object result = call(dao, method, request);

        ResponseEntity response = new ResponseEntity();
        response.status(ResponseEntity.SUCCESS);
        response.result(result);
        out.writeUTF(response.toJson());

      } catch (Exception e) {
        ResponseEntity response = new ResponseEntity();
        response.status(ResponseEntity.ERROR);
        response.result(e.getMessage());
        out.writeUTF(response.toJson());
      }


    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}


