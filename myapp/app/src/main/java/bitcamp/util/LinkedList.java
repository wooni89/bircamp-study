package bitcamp.util;

public class LinkedList implements List {

  // 처음 노드값을 지정
  Node head;
  Node tail;
  int size;

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(Integer.valueOf(100));
    list.add(Integer.valueOf(200));
    list.add(Integer.valueOf(300));
    list.add(Integer.valueOf(400));
    list.add(Integer.valueOf(500));

    print(list);

    // System.out.println(list.remove(Integer.valueOf(200)));
    // System.out.println(list.remove(Integer.valueOf(300)));
    // System.out.println(list.remove(Integer.valueOf(500)));
    // System.out.println(list.remove(Integer.valueOf(100)));
    // System.out.println(list.remove(Integer.valueOf(1000)));

    System.out.println(list.remove(2));
    System.out.println(list.remove(3));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));
    System.out.println(list.remove(0));

    // list.add(Integer.valueOf(1000));
    // list.add(Integer.valueOf(2000));
    print(list);


    // System.out.println(list.retrieve(100));
    // System.out.println(list.retrieve(300));
    // System.out.println(list.retrieve(500));
    // System.out.println(list.retrieve(600));
  }

  static void print(LinkedList list) {
    Object[] arr = list.toArray();
    for (Object obj : arr) {
      System.out.print(obj);
      System.out.print(", ");
    }
    System.out.println();
  }

  @Override
  public boolean add(Object value) {
    // 1. 새 노드를 생성
    Node node = new Node();
    // 2. 새 노드 값 저장
    node.value = value;
    // 3. 리스트의 마지막 노드에 새 노드를 저장
    // 만약 마지막 값이 null이 아닐경우 새 노드를 저장

    if (this.head == null) {
      this.head = node;
    } else if (this.tail != null) {
      this.tail.next = node;
    }
    this.tail = node;
    this.size++;
    return true;
  }

  // 주소 다루는방법
  @Override
  public Object[] toArray() {
    Object[] arr = new Object[this.size];

    // 시작 노드를 헤드값에 저장
    Node cursor = head;
    for (int i = 0; i < this.size; i++) {
      arr[i] = cursor.value;
      // 다음 노드의 주소값을 담아라.
      cursor = cursor.next;
    }
    return arr;
  }

  @Override
  public int size() {
    return this.size;
  }

  // 저장된 값을 찾는 메소드
  @Override
  public Object get(int index) {
    if (!isValid(index)) {
      return null;
    }
    // 초기값 설정
    Node cursor = this.head;

    // value값이 같을때 까지 찾아라. 없으면 null
    for (int i = 0; i < index; i++) {
      cursor = cursor.next;
    }
    return cursor.value;
  }

  @Override
  public boolean remove(Object value) {

    Node prev = null;
    Node cursor = this.head;


    while (cursor != null) { // value값이 같을때 까지 찾아라. 없으면 null
      if (cursor.value.equals(value)) {
        if (prev == null) { // 삭제할 노드가 시작 노드라면
          this.head = cursor.next;
          if (this.head == null) { // 삭제할 노드가 하나 밖에 없다면?
            this.tail = null;
          }

        } else if (cursor.next == null) { // 현재 삭제할 노드가 마지막 노드라면
          this.tail = prev;
          this.tail.next = null;

        } else {
          prev.next = cursor.next; // 중간 노드라면 다음 노드의 주소를 이전노드에 저장
        }
        size--;

        cursor.next = null; // 가비지를 객체를 초기화시켜서 가비지가 인스턴스를 가리키지 않도록 한다.
        cursor.value = null; // 요즘나오는 자바 버젼은 자동으로 가비지를 제거한다.

        return true;
      }

      prev = cursor; // 현재 커서가 가르키는 노드를 prev에 보관한다.
      cursor = cursor.next;
    }
    return false;
  }

  @Override
  public Object remove(int index) {
    if (!isValid(index)) {
      return null;
    }

    // 삭제하려는 노드값 까지 이동.
    Node prev = null;
    Node cursor = this.head;

    // value값이 같을때 까지 찾아라. 없으면 null
    for (int i = 0; i < index; i++) {
      prev = cursor; // 다음 노드로 이동하기 전에 현재 커서가 가르키는 노드를 prev에 보관한다.
      cursor = cursor.next; // 커서를 다음 노드로 이동시킨다.
    }

    Object old = cursor.value;

    if (prev == null) { // 삭제할 노드가 시작 노드라면
      this.head = cursor.next;
      if (this.head == null) { // 삭제할 노드가 하나 밖에 없다면?
        tail = null;
      }

    } else if (cursor.next == null) { // 현재 삭제할 노드가 마지막 노드라면
      this.tail = prev;
      this.tail.next = null;

    } else {
      prev.next = cursor.next; // 현재 커서의 다음 노드를 현재 커서의 이전 노드와 연결
    }
    size--;

    cursor.next = null; // 가비지를 객체를 초기화시켜서 가비지가 인스턴스를 가리키지 않도록 한다.
    cursor.value = null; // 요즘나오는 자바 버젼은 자동으로 가비지를 제거한다.

    return old;

  }

  private boolean isValid(int index) {
    return index >= 0 && index < this.size;
  }

  static class Node { // 중첩클래
    Object value;
    Node next;
  }

}
