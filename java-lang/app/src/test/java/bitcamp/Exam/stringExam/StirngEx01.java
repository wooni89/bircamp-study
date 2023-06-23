package bitcamp.Exam.stringExam;

public class StirngEx01 {

  public static void main(String[] args) {
    // String 레퍼런스
    String s1 = new String("Hello");
    String s2 = new String("Hello");

    System.out.println(s1 == s2);
    // 인스턴스 주소값이 달라서 false
  }

}
