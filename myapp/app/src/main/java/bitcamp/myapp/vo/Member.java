package bitcamp.myapp.vo;

public class Member {

  public int no;
  public String name;
  public String email;
  public String password;
  public char gender;


  private int getNo() {
    return this.no;
  }

  private void setNo(int no) {
    this.no = no;
  }

  private String getName() {
    return this.name;
  }

  private void setName(String name) {
    this.name = name;
  }

  private String getEmail() {
    return this.email;
  }

  private void setEmail(String email) {
    this.email = email;
  }

  private String getPassword() {
    return this.password;
  }

  private void setPassword(String password) {
    this.password = password;
  }

  private char getGender() {
    return this.gender;
  }

  private void setGender(char gender) {
    this.gender = gender;
  }

}
