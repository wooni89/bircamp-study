package bitcamp.test.step02;

// 낱개변수 재사용

public class App {

  public static void main(String[] args) {
    String name;
    int kor;
    int math;
    int eng;
    int sum;
    float avr;

    name = "홍길동";
    kor = 10;
    math = 50;
    eng = 30;

    sum = kor + math + eng;
    avr = sum / 3;

    System.out.printf("%s : 합계 = %d, 평균=%.1f\n", name, sum, avr);

    name = "테이";
    kor = 100;
    math = 50;
    eng = 30;

    sum = kor + math + eng;
    avr = sum / 3;

    System.out.printf("%s : 합계 = %d, 평균=%.1f\n", name, sum, avr);

    name = "버즈";
    kor = 100;
    math = 80;
    eng = 90;

    sum = kor + math + eng;
    avr = sum / 3;

    System.out.printf("%s : 합계 = %d, 평균=%.1f\n", name, sum, avr);

  }
}
