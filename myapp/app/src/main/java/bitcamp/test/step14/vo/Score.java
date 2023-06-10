package bitcamp.test.step14.vo;

public class Score {
  public String name;
  int kor;
  int math;
  int eng;
  private int sum;
  private float avr;

  // 생성자
  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.math = math;
    this.eng = eng;
    this.compute();
  }

  void compute() { // 7
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

}
