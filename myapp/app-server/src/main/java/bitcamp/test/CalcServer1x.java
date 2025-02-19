package bitcamp.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer1x {

  public static void main(String[] args) throws Exception {
    
    class RequestAgent extends Thread {
      
      Socket socket;
      
      public RequestAgent(Socket socket) {
        this.socket = socket;
      }
      
      @Override
      public void run() {
        processRequest(socket);
        super.run();
      }
    }
    
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("Run Server");

      while (true) {
        System.out.println("클라이언트 연결을 기다리는중");
       new RequestAgent(serverSocket.accept()).start();
       System.out.println("클라이언트 요청을 RequestAgent에게 위임함");
      }
    }
  }


  static void processRequest(Socket socket) {

    InetSocketAddress socketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
    System.out.printf("%s(%d) 클라이언트 접속\n", socketAddress.getHostString(),
        socketAddress.getPort());

    try (Socket s = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream()); 
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {


      int result = 0;

      while (true) {
        String op = in.readUTF();
        if (op.equals("quit")) {
          return;
        }


        int value = in.readInt();

        switch (op) {
          case "+":
            result += value;
            break;
          case "-":
            result -= value;
            break;
          case "*":
            result *= value;
            break;
          case "/":
            result /= value;
            break;
          case "%":
            result %= value;
            break;

          default:
            out.writeUTF("지원하지 않는 연산자입니다.");
        }
        out.writeUTF(String.format("%d", result));
      }
    } catch (Exception e) {
      
      System.out.printf("%s(%d) 클라이언트 통신 오류!\n",
          socketAddress.getHostString(), socketAddress.getPort());
    }
  }
}
