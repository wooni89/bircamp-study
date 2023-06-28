package bitcamp.myapp.handler;

import java.util.List;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;


public class MemberAddListener extends AbstractMemberListener {

  public MemberAddListener(List<Member> list) {

    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    Member m = new Member();
    m.setName(prompt.inputString("이름"));
    m.setEmail(prompt.inputString("이메일"));
    m.setPassword(prompt.inputString("비밀번호"));
    m.setGender(inputGender((char) 0, prompt));
    this.list.add(m);

  }


  private static String toGenderString(char gender) {

    return gender == 'M' ? "남성" : "여성";
  }

  private char inputGender(char gender, BreadcrumbPrompt prompt) {

    String label;
    if (gender == 0) {
      label = "성별? \n";
    } else {
      label = String.format("성별(%s)?\n", toGenderString(gender));
    }
    while (true) {
      String menuNo = prompt.inputString(label + "1. 남자\n" + "2. 여자\n" + "> ");

      switch (menuNo) {
        case "1":
          return Member.MALE;
        case "2":
          return Member.FEMALE;
        default:
          System.out.println("무효한 번호 입니다.");
      }
    }
  }


}
