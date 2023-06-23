package bitcamp.Exam.stringExam;

public class StringMutable {

  public static void main(String[] args) {
    StringBuffer buf = new StringBuffer("hello");
    System.out.println(buf);

    buf.replace(2, 4, "xxxx"); // 원본을 바꾼다!
    System.out.println(buf);

  }

}
