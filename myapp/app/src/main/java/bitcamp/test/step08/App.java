package bitcamp.test.step08;

// 1) 낱개변수 사용
// 2) 낱개 변수의 재사용
// 3) 배열사용
// 4) 클래스 이용하여 데이터 타입 정의
// 5) 출력 기능을 별도의 메소드로 분리 ()
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) GRASP 패턴: Information Expert(정보를 갖고 있는 클래스가 그 정보를 다룬다.)
// 8) 인스턴스 메서드 도입
public class App {

  static class Score {
    String name;
    int kor;
    int math;
    int eng;
    int sum;
    float avr;

    void compute() {
      this.sum = this.kor + this.math + this.eng;
      this.avr = this.sum / 3f;
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
    s.compute();
    scores[length++] = s;

    s = new Score();
    s.name = "이동국";
    s.kor = 100;
    s.math = 70;
    s.eng = 70;
    s.compute();
    scores[length++] = s;

    s = new Score();
    s.name = "김연아";
    s.kor = 100;
    s.math = 100;
    s.eng = 100;
    s.compute();
    scores[length++] = s;

    for (int i = 0; i < length; i++) {
      PrintScore(scores[i]);
    }

  }

  static void PrintScore(Score s) {
    System.out.printf("%s : 합계 = %d, 평균=%.1f\n", s.name, s.sum, s.avr);
  }

}