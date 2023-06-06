package com.eomcs.lang.ex04.assignment;

import java.util.*;

public class copy02 {
  static Scanner sc = new Scanner(System.in);

  static int num = 3;
  static String[] name = new String[num];
  static int[] kor = new int[num];
  static int[] eng = new int[num];
  static int[] math = new int[num];
  static int[] sum = new int[num];
  static float[] average = new float[num];

  public static void main(String[] args) {

    scoreInput();

    sc.close();

    for (int i = 0; i < num; i++) {
      System.out.printf("%s %d %d %d %f\n",
          name[i], kor[i], eng[i], math[i], average[i]);
    }

  }

  static void scoreInput() {
    for (int i = 0; i < num; i++) {
      System.out.print("점수입력");
      name[i] = sc.next();
      kor[i] = sc.nextInt();
      eng[i] = sc.nextInt();
      math[i] = sc.nextInt();

      sum[i] = kor[i] + eng[i] + math[i];
      average[i] = sum[i] / 3;
    }
  }

}
