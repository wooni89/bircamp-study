package com.eomcs.io.ex01;

import java.io.File;
import java.util.Arrays;

public class Exam0624x {


  public static void main(String[] args) throws Exception {


    Arrays
        .stream(new File(".").listFiles(file -> file.isFile() && file.getName().endsWith(".java")))
        .forEach(file -> System.out.printf("%s %12d %s\n", file.isDirectory() ? "d" : "-",
            file.length(), file.getName()));

  }

}


