// 폴더 정보 조회 - java.io.File 클래스
package com.eomcs.io.ex01;

import java.io.File;

public class Exam0111x {

  public static void main(String[] args) throws Exception {
    // File 클래스
    // 디렉토리나 파일을 다룰떄 사용하는 클래스
    // 디렉토리나 파일을 생성 삭제 변경할 수 있다.

    // 현재 디렉토리 조회방법
    // - . 으로 표현
    // -JVM을 실행하는 위치가 현재 폴더이다.
    // - 현재 프로젝트 디렉토리를 가르킨다.
    // - 콘솔 : 현재 명령어를 실행하는 위치를 가르킨다.

    File currentDir = new File("파일 경로 ./src/main/java");


    // 경로 메소드.
    currentDir.getName(); // 폴더명
    currentDir.getPath(); // 파일 경로 (프로젝트 폴더 안)
    currentDir.getAbsolutePath(); // 절대경로
    currentDir.getCanonicalPath(); // 정규경로

    // 용량 메소드
    currentDir.getTotalSpace(); // 총크기
    currentDir.getFreeSpace(); // 남은크기
    currentDir.getUsableSpace(); // 가용크기 (사용할수 있는 크기)

    // 폴더확인
    currentDir.isDirectory(); // 디렉토리(폴더) 여부
    currentDir.isFile(); // 파일인지 여부
    currentDir.isHidden(); // 숨김폴더 여부
    currentDir.exists(); // 존재 여부
    currentDir.canExecute(); // 파일 실행가능 여부.
  }

}


