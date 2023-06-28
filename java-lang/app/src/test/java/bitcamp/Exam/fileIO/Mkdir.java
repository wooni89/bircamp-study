package bitcamp.Exam.fileIO;

import java.io.File;

public class Mkdir {

  public static void main(String[] args) {

    File dir = new File("temp");
    if (dir.mkdir()) {
      System.out.println();
    }
  }

}
