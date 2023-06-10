package bitcamp.test.step17.vo;

public class Score {
  private String name; // 일관성을 위해 필요없지만 수정함

  // 직접 접근을 허용했을 때, 무효한 값을 저장할 수 있기 때문에
  // private로 직접 접근을 막았다.
  private int kor;
  private int math;
  private int eng;
  private int sum;
  private float avr;

  public Score(String name, int kor, int eng, int math) {
    this.name = name;
    this.setKor(kor);
    this.setMath(math);
    this.setEng(eng);
  }

  public void compute() {
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

  public int getKor() {
    return this.kor;
  }

  public void setKor(int kor) {
    if (kor < 0 || kor > 100) {
      return;
    }
    this.kor = kor;
    this.compute();
  }

  public int getMath() {
    return this.math;
  }

  public void setMath(int math) {
    if (math < 0 || math > 100) {
      return;
    }
    this.math = math;
    this.compute();
  }

  public int getEng() {
    return this.eng;
  }

  public void setEng(int eng) {
    if (eng < 0 || eng > 100) {
      return;
    }
    this.eng = eng;
    this.compute();
  }

}