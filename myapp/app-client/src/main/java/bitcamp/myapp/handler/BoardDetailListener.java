package bitcamp.myapp.handler;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.Board;
import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class BoardDetailListener implements ActionListener {

  BoardDao boardDao;

  public BoardDetailListener(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void service(BreadcrumbPrompt prompt) {

    int boardNo = (prompt.inputInt("번호 ? "));
    Board board = boardDao.findBy(boardNo);

    if (board == null) {
      System.out.println("해당 번호의 게시글 없습니다.");
      return;
    }

    System.out.printf("제목 : %s\n", board.getTitle());
    System.out.printf("내용 : %s\n", board.getContent());
    System.out.printf("작성자 : %s\n", board.getWriter().getName());
    System.out.printf("작성일 : %s\n", board.getCreatedDate());
    System.out.printf("조회수 : %d\n", board.getViewCount());
    board.setViewCount(board.getViewCount() + 1);
    boardDao.update(board);
  }
}
