// 제네릭(Generic) 문법 정리 - 파라미터 타입 (상속관계 : super) 
package com.eomcs.generic.ex02;

public class Exam0113 {

  static class A {}
  static class B1 extends A {}
  static class B2 extends A {}
  static class C extends B1 {}
  /*
   *   Object
   *     |
   *     A
   *    / \
   *   B1 B2
   *   |
   *   C
   */
  
  static class Box<T> {
    void set(T obj) {}
  }

  public static void main(String[] args) {
    
    Box<? super B1> box1;
    
    box1 = new Box<Object>(); 
    box1 = new Box<A>(); 
    box1 = new Box<B1>();
    // box1 = new Box<C>(); // compile error;

  }
}








