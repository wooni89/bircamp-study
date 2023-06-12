package bitcamp.myapp.vo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class test {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(new test().solution(new int[] { 1, 2, 3, 4, 5, 6 })));
  }

  public int[] solution(int[] num_list) {
    return Arrays.sort(num_list, Collections.reverseOrder());
  }
}
