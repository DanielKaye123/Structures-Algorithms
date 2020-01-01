public class LinkedList<E> {
  private final Node head, tail;
  private int size;

  LinkedList() {
    this.head = new Node(null);
    this.tail = new Node(null);
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public int size() {
    return size;
  }

  private class Node<E> {
    Node next, prev;
    E data;

    Node(E data){
      this.data = data;
      this.prev = null;
      this.next = null;
    }
  }
}
