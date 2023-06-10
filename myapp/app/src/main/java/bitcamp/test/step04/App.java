package bitcamp.test.step04;

// 3) 배열사용
// 4) 클래스 이용하여 데이터 타입 정의
public class App {

  public static void main(String[] args) {

    class Score {
      String name;
      int kor;
      int math;
      int eng;
      int sum;
      float avr;
    }

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    Score s = new Score();
    s.name = "홍길동";
    s.kor = 10;
    s.math = 50;
    s.eng = 30;
    s.sum = s.kor + s.math + s.eng;
    s.avr = s.sum / 3f;

    scores[length++] = s;

    s = new Score();
    s.name = "이동국";
    s.kor = 100;
    s.math = 70;
    s.eng = 70;
    s.sum = s.kor + s.math + s.eng;
    s.avr = s.sum / 3f;

    scores[length++] = s;

    for (int i = 0; i < length; i++) {
      s = scores[i];
      System.out.printf("%s : 합계 = %d, 평균=%.1f\n", s.name, s.sum, s.avr);
    }
  }
}