package bitcamp.test;

public class Exam01 {

  public static void main(String[] args) {
    int age = 12;
    String answer = "";
    String str = Integer.toString(age);
    for (int i = 0; i < str.length(); i++) {
      answer += (char) (str.charAt(i) - '0' + 97);
    }
    System.out.println(answer);

  }
}
