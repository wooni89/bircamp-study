package bitcamp.myapp.handler;

import bitcamp.myapp.vo.Board;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.List;

public class BoardListHandler extends AbstractBoardListener {

  public BoardListHandler(List list) {

    super(list);
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    System.out.println("------------------------------");
    System.out.println("번호, 제목, 작성자, 조회수, 작성일 ");
    System.out.println("------------------------------");

    for (int i = 0; i < this.list.size(); i++) {
      Board board = (Board) this.list.get(i);
      System.out.printf("%d, %s , %s ,%d, %5$tY-%5$tm-%5$td \n", board.getNo(), board.getTitle(),
          board.getWriter(), board.getViewCount(), board.getCreatedDate());
    }

  }


}
