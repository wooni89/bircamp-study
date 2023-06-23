package bitcamp.Exam.stringExam;

public class StringToString {

  public static void main(String[] args) {
    Object obj = new String("Hello");

    String x1 = (String) obj;

    System.out.println(obj == x1);

    String x2 = obj.toString();

    System.out.println(x1 == x2);

  }

}
