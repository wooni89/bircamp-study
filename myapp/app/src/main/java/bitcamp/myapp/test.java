package bitcamp.myapp;

import bitcamp.util.Calculator;

public class test {

  public static void main(String[] args) {
    // 2 * 3 + 7 - 2 / 2 = ?
    Calculator.init(2);
    Calculator.multiple(3);
    Calculator.plus(7);
    Calculator.minus(2);
    Calculator.divide(2);
    System.out.println(Calculator.result);
  }

}
