package bitcamp.myapp.handler;

import java.io.IOException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.BreadcrumbPrompt;


public class MemberUpdateListener implements MemberActionListener {

  MemberDao memberDao;

  public MemberUpdateListener(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) throws IOException {

    int memberNo = (prompt.inputInt("번호 ? "));
    Member m = memberDao.findBy(memberNo);

    if (m == null) {
      prompt.println("해당 번호의 회원이 없습니다.");
      return;
    }

    m.setName(prompt.inputString("이름(%s) ?", m.getName()));
    m.setEmail(prompt.inputString("이메일(%s) ?", m.getEmail()));
    m.setPassword(prompt.inputString("새 비밀번호?"));
    m.setGender(MemberActionListener.inputGender((char) 0, prompt));

    memberDao.update(m);

  }

}
