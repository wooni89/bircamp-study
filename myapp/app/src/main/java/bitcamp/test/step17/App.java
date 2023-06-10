package bitcamp.test.step17;

import bitcamp.test.step17.vo.Score;

// 1) 낱개변수 사용
// 2) 낱개 변수의 재사용
// 3) 배열사용
// 4) 클래스 이용하여 데이터 타입 정의
// 5) 력 기능을 별도의 메소드로 분리 (
// 6) 합계 및 평균을 계산하는 기능을 메서드로 분리
// 7) GRASP 패턴: Information Expert(정보를 갖고 있는 클래스가 그 정보를 다룬다.)
// 8) 인스턴스 메서드 도입
// 9) 객체생성이 복잡한 경우 메소드로 분리하는 것이 낫다. (디자인 패턴: 팩토리 메소드)
//10) GRASP 패턴 : Information Expert
//    -createScore() -> Score 클래스로 이동
//11) 생성자 도입
//12) 클래스를 유지보수를 용의하게 하기위해 소스파일로 분리
//13) 클래스를 유지보수를 용의하게 하기위해 패키지로 분리 import / public
//14) 외부접근 차단과 값 꺼내기 private, getter
//15) 프로그래밍의 일관성을 위해 보통 다른 필드에 대해서도 getter를 만들고 사용한다.
//16) 필드의 접근을 막고 setter를 정의하는 이유
//17) 필드의 직접 접근을 막기 : 인스턴스 변수에 무효한 값이 저장되지 않게 하기 위해
//      getter 정의 : 값을 꺼낼 때 사용
//      setter 정의 : 값을 변경할 때 사용 단,
public class App {

  public static void main(String[] args) {

    final int MAX_SIZE = 10;
    Score[] scores = new Score[MAX_SIZE];
    int length = 0;

    scores[length++] = new Score("powell", 100, 100, 50);
    scores[length++] = new Score("랩몬", 100, 100, 100);
    scores[length++] = new Score("jaedragon", 90, 900, 70);

    scores[0].setKor(10); // setter를 통해서 값 변경 가능. 단 유효한 값만 가능.
    scores[0].compute(); //

    // 합계와 평균계산이 끝난 후에 인스턴스의 국어점수 변경한다면
    // 국영수 점수와 합계 평균이 일치하지 않는 오류가 발생한다.
    // 국영수 점수를 변경 한 후에 compute()를 호출한다면?
    // 만약 개발자가 compute() 호출하는것을 잊어 버린다면 아무소용없다.
    // 만약 유효하지 않은 국영수 점수를 입력한다면?
    // 막을 방법은 없음.
    // scores[0].kor = 70; --> 직접접근불가

    for (int i = 0; i < length; i++) {
      printScore(scores[i]);
    }

  }

  static void printScore(Score s) {
    System.out.printf("%s : 국어 : %d, 영어 : %d, 수학 : %d, 합계 = %d, 평균=%.1f\n",
        s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAvr());
  }

}