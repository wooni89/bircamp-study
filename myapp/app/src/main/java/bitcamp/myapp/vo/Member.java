package bitcamp.myapp.vo;

public class Member {

  private static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  // 인스턴스 필드는 각각 개별적으로 유지해야 하는 값을 저장할 때 사용한다.
  // new 명령을 통해 변수를 Heap영역에 생성한다.

  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  // 생성자는 인스턴스를 생성한 후 필드를 초기화 시키는 일을 한다.
  // 인스턴스를 사용할 때 문제가 없도록 유효한 값으로 초기화를 시킨다.
  // 기본 생성자는 개발자가 생성자를 정의하지 않을때
  // 컴파일러가 추가해주는 생성자다.
  // 물론 개발자가 직접 추가할 수도 있다.

  public Member() {
    this.no = userId++;
  }

  public int getNo() {
    return this.no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public char getGender() {
    return this.gender;
  }

  public void setGender(char gender) {
    this.gender = gender;
  }

}
