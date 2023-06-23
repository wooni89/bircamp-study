package bitcamp.util;

public class Menu {

  private String title;
  ArrayList listeners = new ArrayList();

  public Menu(String title) {
    this.title = title;
  }

  // 생성자에서 생성자를 호출 할때는 this(메서드)를 호출 할 수 있다.
  public Menu(String title, ActionListener listener) {
    this(title);
    this.addActionListener(listener);
  }

  public void addActionListener(ActionListener listener) {
    this.listeners.add(listener);
  }

  public void removeActionListener(ActionListener listener) {
    this.listeners.remove(listener);
  }

  public String getTitle() {
    return title;
  }

  public void execute(BreadcrumbPrompt prompt) {
    for (int i = 0; i < listeners.size(); i++) {
      ActionListener listener = (ActionListener) listeners.get(i);
      listener.service(prompt);
    }
  }

}
