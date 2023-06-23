package bitcamp.test.p1;


class A {
  static int v1;

  static void m1() {

  }

  static {
    System.out.println(" A 클래스의 스태틱 블록 실행");
  }
}

// static 블럭은 여러개 만들어도 하나의 스태틱필드로 묶기 때문에 한번만 선언하자!


public class Exam {

  public static void main(String[] args) {
    A obj;

    // A.v1 = 100; // A클래스의 스태틱변수인 v1에 100을 저장
    // A.m1();

    Class cls; // class를 변수명으로 사용하고 싶을떄 clazz 또는 cls 로 사용한다.
    try {
      Class.forName("bitcamp.test.p1.A"); // forName 뭔지 검색하기
    } catch (ClassNotFoundException e) {
      System.out.println("클래스못찾음");
    }
  }

}
