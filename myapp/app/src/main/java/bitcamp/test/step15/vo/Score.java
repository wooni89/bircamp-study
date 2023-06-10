package bitcamp.test.step15.vo;

public class Score {
  private String name; // 일관성을 위해 필요없지만 수정함
  int kor;
  int eng;
  int math;
  private int sum;
  private float avr;

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.compute();
  }

  void compute() {
    this.sum = this.kor + this.math + this.eng;
    this.avr = this.sum / 3f;
  }

  // getter : Private 으로 접근이 막힌 변수값을 리턴해주는 메소드
  public int getSum() {
    return this.sum;
  }

  public float getAvr() {
    return this.avr;
  }

  public String getName() {
    return this.name;
  }

}
