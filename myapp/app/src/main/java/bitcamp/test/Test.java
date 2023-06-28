package bitcamp.test;

public class Test {

  public static void main(String[] args) {

    System.out.println(factorial(5, 100));
  }

  static int factorial(int a, long b) {

    System.out.println(a);

    return factorial(a - 1, b + 1) * a;


  }

}
