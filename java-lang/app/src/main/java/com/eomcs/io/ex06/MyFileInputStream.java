package com.eomcs.io.ex06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileInputStream extends FileInputStream {

  byte[] buf = new byte[8192];
  int length; // 버퍼에 저장한 바이트 수
  int pos; // 읽을 바이트의 인덱스

  public MyFileInputStream(String name) throws FileNotFoundException {
    super(name);
  }

  @Override
  public int read() throws IOException {
    if (pos == length) { // 버퍼의 데이터를 다 읽었다면
      length = this.read(buf); // 버퍼 크기만큼 데이터를 읽어 들인다.
      if (length == -1) {
        length = 0;
        return -1;
      }
      pos = 0; // 버퍼 시작부터 읽을수 있도록 위치를 0으로 설정
      System.out.println(length + "바이트 읽음");
    }
    return buf[pos++] & 0x000000ff;
    // byte -> int 형변환 시 맨 앞자리를 기준으로 빈칸을 채움으로 음수 방지를 위해 설정
  }

}
