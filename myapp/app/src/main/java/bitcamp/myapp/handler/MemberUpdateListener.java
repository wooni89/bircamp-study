package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;


public class MemberUpdateListener extends AbstractMemberListener {

  public MemberUpdateListener(List list) {

    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    int memberNo = (prompt.inputInt("번호 ? "));
    Member m = this.findBy(memberNo);

    if (m == null) {
      System.out.println("해당 번호의 회원이 없습니다.");
      return;
    }

    m.setName(prompt.inputString("이름(%s) ?", m.getName()));
    m.setEmail(prompt.inputString("이메일(%s) ?", m.getName()));
    m.setPassword(prompt.inputString("새 비밀번호?"));
    m.setGender(inputGender((char) 0, prompt));
    return;

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

  private static String toGenderString(char gender) {

    return gender == 'M' ? "남성" : "여성";
  }

}