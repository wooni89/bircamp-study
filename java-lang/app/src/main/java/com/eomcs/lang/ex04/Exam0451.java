package com.eomcs.lang.ex04;

import java.time.LocalDate;

//# 레퍼런스 변수
//
public class Exam0451 {
  public static void main(String[] args) {

    LocalDate d1 = LocalDate.now();
    LocalDate d2 = d1;

    System.out.printf("%d, %d\n", d1.getDayOfMonth(), d2.getDayOfMonth());

    d1 = d1.withDayOfMonth(22);

    System.out.printf("%d, %d\n", d1.getDayOfMonth(), d2.getDayOfMonth());
    // Localdate는 불변객체로 참조형 매개변수 값을 설정 할 수 없음. d2값을 따로 지정해줘야 함.

    // d1에 저장된 일자 값을 변경한 후
    // d2에 저장된 일자 값을 출력해 보면 d1과 똑같이 변경되어 있다.
    // 이유는?
    // d1과 d2에 저장되는 것은 값이 아니라 (날짜 정보가 저장되어 있는 메모리의) 주소이다.
    // 이렇게 값을 저장하지 않고 값이 저장된 위치(주소)를 저장하는 변수를
    // "레퍼런스 (변수)"라 부른다.
    // 자바 기본 데이터 타입(byte, short, int, long, float, double, boolean, char)을
    // 제외한 모든 타입의 변수는 레퍼런스이다.
  }
}
