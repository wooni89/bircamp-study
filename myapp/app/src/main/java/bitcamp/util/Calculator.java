package bitcamp.util;

public class Calculator {

  private int result = 0;
  private static int result2 = 0;

  public int getResult() {
    return this.result;
  }

  public void init(int a) {
    this.result = a;
  }

  public int plus(int a) {
    return this.result += a;

  }

  public int minus(int a) {
    return this.result -= a;

  }

  public int multiple(int a) {
    return this.result *= a;

  }

  public int divide(int a) {
    return this.result /= a;
  }

}
