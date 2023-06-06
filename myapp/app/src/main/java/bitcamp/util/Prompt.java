package bitcamp.util;

import java.util.Scanner;

//클래스 이름이 메소드와 같으면 메소드 이름을 받아오는 값의 함수로 변경해준다.
public class Prompt {

  static Scanner scanner = new Scanner(System.in);

  public static String inputString(String title) {

    System.out.print(title);
    return scanner.nextLine();

  }

  public static void close() {
    scanner.close();
  }

}
