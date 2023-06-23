package bitcamp.util;

public class Queue extends LinkedList {

  public static void main(String[] args) {
    Queue q = new Queue();

    q.offer("111");
    q.offer("222");
    q.offer("333");
    q.offer("444");
    q.offer("555");

    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println(q.poll());

    System.out.println(q.poll());

  }

  public void offer(Object value) {
    this.add(value);
  }

  public Object poll() {
    if (this.size() == 0) {
      return null;
    }
    return this.remove(0);
  }

}
