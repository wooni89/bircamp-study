package bitcamp.Exam.wrraper;

public class WrapperAutoboxing {

  public static void main(String[] args) {
    Integer obj = 100; // Integer.valueOf(100); 으로 자동 변경
    System.out.println(obj);

    Integer obj2 = Integer.valueOf(300);
    int i = obj2;
    System.out.println(i);


  }

}
