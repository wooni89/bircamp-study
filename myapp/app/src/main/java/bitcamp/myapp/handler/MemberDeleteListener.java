package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;


public class MemberDeleteListener extends AbstractMemberListener {

  public MemberDeleteListener(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    if (!this.list.remove(new Member(prompt.inputInt("번호? ")))) {
      System.out.println("해당 번호에 회원정보가 없습니다.");
    }
  }
}
