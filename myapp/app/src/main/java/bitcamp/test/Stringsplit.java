package bitcamp.test;

import java.util.Arrays;

public class Stringsplit {

  public static void main(String[] args) {
    String ham = "HAMBERGER";
    String[] ary = ham.split("");
    char[] cary = ham.toCharArray();

    System.out.println(Arrays.toString(ary));
    System.out.println(Arrays.toString(cary));
  }

}
