package bitcamp.test.step10;

// 1) 낱개변수 사용
// 2) 낱개 변수의 재사용
// 3) 배열사용
// 4) 클래스 이용하여 데이터 타입 정의
// 5) 출력 기능을 별도의 메소드로 분리 (
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) GRASP 패턴: Information Expert(정보를 갖고 있는 클래스가 그 정보를 다룬다.)
// 8) 인스턴스 메서드 도입
// 9) 객체생성이 복잡한 경우 메소드로 분리하는 것이 낫다. (디자인 패턴: 팩토리 메소드)
//10) GRASP 패턴 : Information Expert
//     - 
public class App {

  static class Score {
    String name;
    int kor;
    int math;
    int eng;
    int sum;
    float avr;

    void compute() { // 7
      this.sum = this.kor + this.math + this.eng;
      this.avr = this.sum / 3f;
    }

    static Score create(String name, int kor, int math, int eng) {
      Score s = new Score();
      s.name = name;
      s.kor = kor;
      s.math = math;
      s.eng = eng;
      s.compute();
      return s;
    }
  }

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    scores[length++] = Score.create("powell", 100, 100, 50);
    scores[length++] = Score.create("랩몬", 100, 100, 100);
    scores[length++] = Score.create("jaedragon", 60, 50, 70);

    for (int i = 0; i < length; i++) {
      PrintScore(scores[i]);
    }

  }

  static void PrintScore(Score s) {
    System.out.printf("%s : 합계 = %d, 평균=%.1f\n", s.name, s.sum, s.avr);
  }

}