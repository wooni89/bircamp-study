package bitcamp.test.step13;

import bitcamp.test.step13.vo.Score;

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
//    -createScore() -> Score 클래스로 이동
//11) 생성자 도입
//12) 클래스를 유지보수를 용의하게 하기위해 소스파일로 분리
//13) 클래스를 유지보수를 용의하게 하기위해 패키지로 분리
public class App {

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    scores[length++] = new Score("powell", 100, 100, 50);
    scores[length++] = new Score("랩몬", 100, 100, 100);
    scores[length++] = new Score("jaedragon", 90, 90, 70);

    scores[0].sum = 600;

    for (int i = 0; i < length; i++) {
      PrintScore(scores[i]);
    }

  }

  static void PrintScore(Score s) {
    System.out.printf("%s : 합계 = %d, 평균=%.1f\n", s.name, s.sum, s.avr);
  }

}