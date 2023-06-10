package bitcamp.test.step12;

class Score {
  String name;
  int kor;
  int math;
  int eng;
  int sum;
  float avr;

  // 생성자
  Score(String name, int kor, int eng, int math) {
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
