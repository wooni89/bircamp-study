package bitcamp.myapp.handler;

import java.text.SimpleDateFormat;
import java.util.List;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class BoardListListener implements ActionListener {

  BoardDao boardDao;
  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  public BoardListListener(BoardDao boardDao) {
    this.boardDao = boardDao;

  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    prompt.println("-----------------------------------");
    prompt.println("번호, 제목, 작성자, 조회수, 작성일 ");
    prompt.println("-----------------------------------");

    List<Board> list = boardDao.list();
    for (Board board : list) {
      prompt.printf("%d, %s, %s, %d, %s\n",
        board.getNo(),
        board.getTitle(),
        board.getWriter().getName(),
        board.getViewCount(),
        dateFormat.format(board.getCreatedDate()));
    }

  }


}
