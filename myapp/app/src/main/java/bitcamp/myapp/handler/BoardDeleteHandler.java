package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardDeleteHandler extends AbstractBoardListener {

  public BoardDeleteHandler(List list) {
    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    if (!this.list.remove(new Board(prompt.inputInt("번호 ? ")))) {
      System.out.println("해당 번호에 회원정보가 없습니다.");
    }

  }

}
