public class LinkedList<E> {
  private final Node head, tail;
  private int size;

  LinkedList() {
    this.head = new Node(null);
    this.tail = new Node(null);
    head.setNext(tail);
    tail.setPrev(head);
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.size() == 0;
  }

  public int size() {
    return size;
  }

  public void add(E data) {
    size++;
    Node<E> node = new Node<>(data);
    node.insertBeforeNode(tail);
  }

  public E get(int index) {
    Node<E> node = nodeAtIndex(index);
    return node != null ? node.getData() : null;
  }

  private Node<E> nodeAtIndex(int index) {
    assert (indexInRange(index));
    if (!indexInRange(index)){return null;}
    Node<E> node = head.getNext();
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    return node;
  }

  public boolean contains(E data) {
    for(Node<E> node = head; node != tail; node = node.getNext()) {
      if (node.getData() == data) {
        return true;
      }
    }
    return false;
  }

  private boolean indexInRange(int index) {
    return index >= 0 && index < size();
  }

  private class Node<E> {
    Node next, prev;
    E data;

    Node(E data){
      this.data = data;
      this.prev = null;
      this.next = null;
    }

    private E getData() {
      return this.data;
    }
    private void setPrev(Node<E> node) {
      node.next = this;
      this.prev = node;
    }

    private void setNext(Node<E> node) {
      node.prev = this;
      this.next = node;
    }

    private Node<E> getPrev() {
      return this.prev;
    }

    private Node<E> getNext() {
      return this.next;
    }

    private void insertBeforeNode(Node<E> node) {
      this.setPrev(node.getPrev());
      this.setNext(node);
    }

  }
}
