package bitcamp.util;

import java.io.InputStream;
import java.util.Scanner;

// 클래스 이름이 메소드와 같으면 메소드 이름을 받아오는 값의 함수로 변경해준다.
public class Prompt {

  private Scanner scanner = new Scanner(System.in);

  // default constructor 정의
  public Prompt() {
    scanner = new Scanner(System.in);
  }

  // 다른 입력 도구와 연결한다면
  public Prompt(InputStream in) {
    scanner = new Scanner(in);
  }

  public String inputString(String title, Object... args) {
    System.out.printf(title, args);
    return this.scanner.nextLine();

  }

  public int inputInt(String title, Object... args) {
    return Integer.parseInt(inputString(title, args));
  }

  public void close() {
    this.scanner.close();
  }

}
