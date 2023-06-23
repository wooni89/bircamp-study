package bitcamp.myapp;

import bitcamp.myapp.handler.BoardAddListener;
import bitcamp.myapp.handler.BoardDeleteHandler;
import bitcamp.myapp.handler.BoardDetailHandler;
import bitcamp.myapp.handler.BoardListHandler;
import bitcamp.myapp.handler.BoardUpdateHandler;
import bitcamp.myapp.handler.FooterListener;
import bitcamp.myapp.handler.HeadListener;
import bitcamp.myapp.handler.HelloListener;
import bitcamp.myapp.handler.MemberAddListener;
import bitcamp.myapp.handler.MemberDeleteListener;
import bitcamp.myapp.handler.MemberDetailListener;
import bitcamp.myapp.handler.MemberListListener;
import bitcamp.myapp.handler.MemberUpdateListener;
import bitcamp.util.ArrayList;
import bitcamp.util.BreadcrumbPrompt;
import bitcamp.util.LinkedList;
import bitcamp.util.Menu;
import bitcamp.util.MenuGroup;

public class App {

  public static void main(String[] args) {

    ArrayList memberList = new ArrayList();
    LinkedList boardlist = new LinkedList();
    LinkedList redinglist = new LinkedList();

    BreadcrumbPrompt prompt = new BreadcrumbPrompt();

    MenuGroup mainMenu = new MenuGroup("메인");

    MenuGroup memberMenu = new MenuGroup("회원");
    memberMenu.add(new Menu("등록", new MemberAddListener(memberList)));
    memberMenu.add(new Menu("목록", new MemberListListener(memberList)));
    memberMenu.add(new Menu("조회", new MemberDetailListener(memberList)));
    memberMenu.add(new Menu("변경", new MemberUpdateListener(memberList)));
    memberMenu.add(new Menu("삭제", new MemberDeleteListener(memberList)));
    mainMenu.add(memberMenu);

    MenuGroup boardMenu = new MenuGroup("게시판");
    boardMenu.add(new Menu("등록", new BoardAddListener(boardlist)));
    boardMenu.add(new Menu("목록", new BoardListHandler(boardlist)));
    boardMenu.add(new Menu("조회", new BoardDetailHandler(boardlist)));
    boardMenu.add(new Menu("변경", new BoardUpdateHandler(boardlist)));
    boardMenu.add(new Menu("삭제", new BoardDeleteHandler(boardlist)));
    mainMenu.add(boardMenu);

    MenuGroup readingMenu = new MenuGroup("독서록");
    readingMenu.add(new Menu("등록", new BoardAddListener(redinglist)));
    readingMenu.add(new Menu("목록", new BoardListHandler(redinglist)));
    readingMenu.add(new Menu("조회", new BoardDetailHandler(redinglist)));
    readingMenu.add(new Menu("변경", new BoardUpdateHandler(redinglist)));
    readingMenu.add(new Menu("삭제", new BoardDeleteHandler(redinglist)));
    mainMenu.add(readingMenu);

    Menu helloMenu = new Menu("안녕");
    helloMenu.addActionListener(new HeadListener());
    helloMenu.addActionListener(new HelloListener());
    helloMenu.addActionListener(new FooterListener());
    mainMenu.add(helloMenu);

    printTitle();

    mainMenu.execute(prompt);

    prompt.close();
  }

  static void printTitle() {
    System.out.println("나의 목록 관리 시스템");
    System.out.println("-------------------------");

  }

}
