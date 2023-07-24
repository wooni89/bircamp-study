package bitcamp.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// stateless + session 으로 통신하기
public class CalcClient3 {

  static Pattern pattern = Pattern.compile("[0-9]+|\\p{Punct}"); // 정규식 [0-9] 까지 집합

  public static void main(String[] args) {

    try (Scanner keyScan = new Scanner(System.in)) {
      String uuid = "";
      
      while (true) {
        System.out.print("계산식(예 +3) > ");
        String input = keyScan.nextLine();
        if (input.equals("quit")) {
          break;
        }
        
        Expression expr = null;
        try {
           expr = parseExpression(input);
        } catch (ExpressionParseException e) {
          System.out.println(e.getMessage());
          continue;
        }

        try (Socket socket = new Socket("localhost", 8888);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream())) {

          out.writeUTF(uuid);
          out.writeUTF(expr.op);
          out.writeInt(expr.value);

          uuid = in.readUTF();
          String result = in.readUTF();
          System.out.printf("결과 : %s\n", result);   

        } catch (IOException e) {
          System.out.println("서버 통신 오류");
        }    
      }
    }
  }

  public static Expression parseExpression(String expr) throws ExpressionParseException {
    // 0 부터 9까지 1개인것을 찾고 특수문자 같은것을 찾아라

    try {
      Matcher matcher = pattern.matcher(expr); // 일치하는 값을 찾기

      ArrayList<String> values = new ArrayList<>();

      // 같은 것을찾으면 출력
      while (matcher.find()) {
        values.add(matcher.group());
      }

      if (values.size() != 2) {
        throw new Exception("계산식이 옳지 않습니다.");
      }

      Expression obj = new Expression();
      obj.op = values.get(0);
      obj.value = Integer.parseInt(values.get(1));

      return obj;
    } catch (Exception e) {
      throw new ExpressionParseException(e);
    }
  }

  static class Expression {
    String op;
    int value;
  }
}
