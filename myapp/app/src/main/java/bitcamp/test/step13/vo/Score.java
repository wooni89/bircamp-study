package bitcamp.test.step13.vo;

public class Score {
  public String name;
  int kor;
  int math;
  int eng;
  public int sum;
  public float avr;

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

}
