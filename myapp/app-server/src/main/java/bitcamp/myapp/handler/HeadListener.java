package bitcamp.myapp.handler;

import bitcamp.util.ActionListener;
import bitcamp.util.BreadcrumbPrompt;

public class HeadListener implements ActionListener {

  @Override
  public void service(BreadcrumbPrompt prompt) {
    prompt.println("------------- NaverCloud --------------");

  }
}
