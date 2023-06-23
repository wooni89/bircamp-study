package bitcamp.myapp.vo;

public class Member {

  private static int userId = 1;

  public static final char MALE = 'M';
  public static final char FEMALE = 'W';

  private int no;
  private String name;
  private String email;
  private String password;
  private char gender;

  public Member() {
    this.no = userId++;
  }


  // 같은 기능을 수행하는 생성자가 위에 있다.
  // 다만 파라미터가 다를 뿐이다.
  // 생성자 오버로딩(Overloading)
  public Member(int no) {
    this.no = no;
  }


  // Object의 equals()는 Member 인스턴스를 비교하는데 적합하지 않다.
  // Object의 equals()는 단순히 인스턴스의 주소가 같은지 비교하기 떄문.
  // 우리가 원하는 것은 인스턴스의 주소가 다르더라도 두인스턴스는 같은것으로 처리하는것.
  // 그래서 수퍼 클래스의 equlas를 재정의 한것
  // 이것을 Overriding 이라 부른다.
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }

    // 위 조건에서 this가 가르키는 인스턴스의 클래스와 파라미터 obj가 가르키는 인스턴스의 클래스가 같다고 결론이 나서
    // 다음과 같이 obj를 Member 타입으로 형변환 한다.
    // Member m = (Member) obj;
    // if (this.getNo() != m.getNo()) {
    // return false;
    // }
    //
    // if (this.getName() != null && this.getName().equals(m.getEmail())) {
    // return false;
    // }
    //
    // if (this.getEmail() != null && this.getEmail().equals(m.getEmail())) {
    // return false;
    // }
    //
    // if (this.getPassword() != null && this.getPassword().equals(m.getPassword())) {
    // return false;
    // }
    //
    // if (this.getGender() != m.getGender()) {
    // return false;
    // }
    return true;
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
