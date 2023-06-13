package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.Prompt;

public class BoardHandler {

  static final int MAX_SIZE = 100;
  static Board[] boards = new Board[MAX_SIZE];

  static int length = 0;

  public static void inputBoard() {
    if (!available()) {
      System.out.println("더이상 입력할 수 없습니다.");
      return;
    }

    Board board = new Board();
    board.setTitle(Prompt.inputString("제목 ? "));
    board.setContent(Prompt.inputString("내용 ? "));
    board.setWriter(Prompt.inputString("작성자 ? "));
    board.setPassword(Prompt.inputString("암호 ? "));
    boards[length++] = board;
  }

  // 위에서 만든 Board 인스턴스의 주소를 잃어버리지 않게
  // 레퍼런스 배열에 담는다.

  public static void printBoards() {

    System.out.println("------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 작성일 ");
    System.out.println("------------------------------");



    for (int i = 0; i < length; i++) {
      Board board = boards[i];

      // 게시글의 등록일 값을 가져와서 Date 인스턴스에 저장한다.

      System.out.printf("%d, %s , %s ,%d, %5$tY-%5$tm-%5$td \n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }
  }

  public static void viewBoard() {
    // String BoardNo = Prompt.inputString("번호 ? ");
    // // 입력받은 번호를 가지고 배열에서 해당 회원을 찾아야 한다.
    // for (int i = 0; i < length; i++) {
    // Board board = boards[i];
    // if (board.getNo() == Integer.parseInt(BoardNo)) {
    // System.out.printf("이름 : %s\n", board.getName());
    // System.out.printf("이메일 : %s\n", board.getEmail());
    // System.out.printf("성별 : %s\n", toGenderString(board.getGender()));
    // // i번째 저장된 회원정보출력
    // return;
    // }
    // }
    // System.out.println("해당 번호의 회원이 없습니다.");
  }

  // public static String toGenderString(char gender) {
  // return gender == 'M' ? "남성" : "여성";
  // }

  public static void updateBoard() {
    // String BoardNo = Prompt.inputString("번호 ? ");
    // for (int i = 0; i < length; i++) {
    // Board m = boards[i];
    // if (m.getNo() == Integer.parseInt(BoardNo)) {
    // System.out.printf("이름(%s) ?", board.getName());
    // m.setName(Prompt.inputString(""));
    // System.out.printf("이메일(%s) ?", m.getName());
    // m.setEmail(Prompt.inputString(""));
    // System.out.printf("새 비밀번호?");
    // m.setPassword(Prompt.inputString(""));
    // m.setGender(inputGender(m.getGender()));
    // return;
    // }
    // }
    // System.out.println("해당 번호의 회원이 없습니다.");
  }

  // private static char inputGender(char gender) {
  // String label;
  // if (gender == 0) {
  // label = "성별? \n";
  // } else {
  // label = String.format("성별(%s)?\n", toGenderString(gender));
  // }
  // while (true) {
  // String menuNo = Prompt.inputString(label + "1. 남자\n" + "2. 여자\n" + "> ");
  //
  // switch (menuNo) {
  // case "1":
  // return Board.MALE;
  // case "2":
  // return Board.FEMALE;
  // default:
  // System.out.println("무효한 번호 입니다.");
  // }
  // }
  // }

  public static void deleteBoard() {
    // int boardNo = Prompt.inputInt("번호? ");
    // int deletedIndex = indexOf(BoardNo);
    //
    // if (deletedIndex == -1) {
    // System.out.println("해당 번호에 회원정보가 없습니다.");
    // return;
    // }
    //
    // for (int i = deletedIndex; i < length - 1; i++) {
    // Boards[i] = Boards[i + 1];
    // }
    //
    // Boards[--length] = null;

  }

  private static int indexOf(int BoardNo) {
    // for (int i = 0; i < length; i++) {
    // Board m = boards[i];
    // if (m.getNo() == BoardNo) {
    // return i;
    // }
    // }
    // return -1;

  }

  // 외부에서 메소드를 쓸 일이 없을 경우 public을 사용할 필요 없음
  private static boolean available() {
    return length < MAX_SIZE;
  }

}