package bitcamp.test.step07;

// 2) 낱개 변수의 재사용
// 3) 배열사용
// 4) 클래스 이용하여 데이터 타입 정의
// 5) 출력 기능을 별도의 메소드로 분리 ()
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) GRASP 패턴: Information Expert(정보를 갖고 있는 클래스가 그 정보를 다룬다.)
//      - compute() 메소드를 Score 클래스로 이동 후 Score 클래스에서 받아오도록 선언
public class App {

  static class Score {
    String name;
    int kor;
    int math;
    int eng;
    int sum;
    float avr;

    static void compute(Score s) { // 7
      s.sum = s.kor + s.math + s.eng;
      s.avr = s.sum / 3f;
    }
  }

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    Score s = new Score();
    s.name = "랩몬";
    s.kor = 10;
    s.math = 50;
    s.eng = 30;
    Score.compute(s);
    scores[length++] = s;

    s = new Score();
    s.name = "이동국";
    s.kor = 100;
    s.math = 70;
    s.eng = 70;
    Score.compute(s);
    scores[length++] = s;

    s = new Score();
    s.name = "김연아";
    s.kor = 100;
    s.math = 100;
    s.eng = 100;
    Score.compute(s);
    scores[length++] = s;

    for (int i = 0; i < length; i++) {
      PrintScore(scores[i]);
    }

  }

  static void PrintScore(Score s) {
    System.out.printf("%s : 합계 = %d, 평균=%.1f\n", s.name, s.sum, s.avr);
  }

}