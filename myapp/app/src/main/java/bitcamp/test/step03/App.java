package bitcamp.test.step03;

// 3) 배열사용
public class App {

  public static void main(String[] args) {
    String[] name = new String[10];
    int[] kor = new int[10];
    int[] math = new int[10];
    int[] eng = new int[10];
    int[] sum = new int[10];
    float[] avr = new float[10];
    int length = 0;

    name[length] = "홍길동";
    kor[length] = 10;
    math[length] = 50;
    eng[length] = 30;

    sum[length] = kor[length] + math[length] + eng[length];
    avr[length] = sum[length] / 3f;

    length++;

    for (int i = 0; i < length; i++) {
      System.out.printf("%s : 합계 = %d, 평균=%.1f\n", name[i], sum[i], avr[i]);
    }

  }
}