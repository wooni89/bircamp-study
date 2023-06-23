package bitcamp.test;

import bitcamp.test.p1.A;

public class Test3 extends A {

  public static void main(String[] args) {
    A obj = new A();

    // obj.v1 = 100;
    // obj.v2 = 200;
    // obj.v3 = 300;
    obj.v4 = 400;

    // obj.m1(); // 접근불가

    Test3 obj2 = new Test3();
    obj2.m3();
    // obj2.v1 = 100; // 접근 불가!
    // obj2.v2 = 200; // 접근 불가!
    obj2.v3 = 300; // 상속받아서 만든 필드. 자식 클래스가 접근 가능!
    obj2.m(); // 자식클래스가 상속받아서 사용하는 메소드
  }

  static void m2() {

  }

  void m3() {

  }
}
