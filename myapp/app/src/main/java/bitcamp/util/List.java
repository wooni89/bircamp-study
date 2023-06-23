package bitcamp.util;

public interface List {
  boolean add(Object value); // 시그니쳐 리턴타입

  Object get(int index);

  Object[] toArray();

  Object remove(int index);

  boolean remove(Object value);

  int size();

}
