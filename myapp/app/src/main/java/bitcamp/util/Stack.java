package bitcamp.util;

// LinkedList에 있는 기능을 사용가능하다.
public class Stack extends LinkedList {

  public static void main(String[] args) {
    Stack s = new Stack();

    s.push("woon");
    s.push("qqq");
    s.push("bbb");
    s.push("222");
    s.push("111");

    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());

    System.out.println(s.pop());
  }

  public void push(Object value) {
    // 목록 맨 끝에 추가 한다.
    // 따로 만들 필요 없다.
    // 슈퍼 클래스에 있는 메서드를 이용하여 기능을 구현한다.
    this.add(value); // 상속 받은 메서드 = 서브클래스에서 사용할 수 있는 슈퍼클래스 메서드.
  }

  public Object pop() {
    if (this.empty()) {
      return null;
    }

    return this.remove(this.size() - 1);
  }

  public Object peek() {
    if (this.empty()) {
      return null;
    }
    return this.get(this.size() - 1);
  }

  public boolean empty() {
    return this.size() == 0;
  }
}
