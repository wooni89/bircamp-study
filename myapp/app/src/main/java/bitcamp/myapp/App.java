package bitcamp.myapp;

import bitcamp.myapp.handler.MemberHandler;
import bitcamp.util.Prompt;

public class App {

  public static void main(String[] args) {

    printTitle();

    while (MemberHandler.available()) {

      MemberHandler.inputMember();

      if (!promptContinue()) {
        break;
      }

    }

    MemberHandler.printMembers();

    Prompt.close();

  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------------");
  }

  static boolean promptContinue() {

    String response = Prompt.inputString("계속하시겠습니까? (Y/N)");
    // equalsIgnoreCase = 대소문자를 구분하지 않음.
    if (!"".equals(response) && !"Y".equalsIgnoreCase(response)) {
      return false;

    }
    return true;
  }

}
