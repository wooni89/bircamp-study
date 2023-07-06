package bitcamp.util;


// caller : Menu
// collee : 메뉴를 처리할 객체
public interface ActionListener {

  // 사용자가 메뉴를 선택 했을 떄 호출 된다.
  void service(BreadcrumbPrompt prompt);
}
