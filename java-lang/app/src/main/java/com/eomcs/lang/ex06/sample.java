import java.util.*;

public class Main {
  static printClass[] printAry = new printClass[6];
  static {
    printAry[0] = new printClass(8, "아동");
    printAry[1] = new printClass(14, "청소년");
    printAry[2] = new printClass(20, "성인");
    printAry[3] = new printClass(39, "청년");
    printAry[4] = new printClass(59, "어른");
    printAry[5] = new printClass(65, "노인");
  }

  public static void main(String[] args) {
    Scanner agescan = new Scanner(System.in);
    System.out.println("나이를 입력하세여 ");
    int age = agescan.nextInt();
    print(age);
  }

  static void print(int age) {
    for (printClass printObj : printAry) {
      if (age < printObj.age) {
        System.out.println(printObj.printStr);
        break;
      }
    }
  }

  static class printClass {
    public int age;
    public String printStr;

    public printClass(int age, String str) {
      this.age = age;
      this.printStr = str;
    }
  }
}