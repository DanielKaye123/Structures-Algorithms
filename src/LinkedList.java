public class LinkedList<E> {
  private final Node head, tail;
  private int size;

  LinkedList() {
    this.head = new Node(null);
    this.tail = new Node(null);
    head.setNext(tail);
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

  public void add(E data, int index) {
    if(!indexInRangeInclusive(index)) {
      return;
    }
    size++;
    Node<E> node = new Node<>(data);
    node.insertBeforeNode(nodeAtIndex(index));
  }

  public void addFirst(E data) {
    size++;
    Node<E> node = new Node<>(data);
    node.insertAfterNode(head);
  }

  public E pollLast() {
    if (isEmpty()) {
      return null;
    }
    size--;
    Node<E> polledNode = tail.getPrev();
    polledNode.removeFromList();

    return polledNode.getData();
  }

  public E pollFirst() {
    if (isEmpty()) {
      return null;
    }
    size--;
    Node<E> polledNode = head.getNext();
    polledNode.removeFromList();
    return polledNode.getData();
  }

  public E remove(int index) {
    if (!indexInRange(index)) {
      return null;
    }
    size--;
    Node<E> node = nodeAtIndex(index);
    node.removeFromList();
    return node.getData();
  }

  public boolean remove(E data) {
    int indexOfItem = indexOf(data);
    remove(indexOfItem);
    return indexOfItem >= 0 ? true : false;
  }

  public E get(int index) {
    Node<E> node = nodeAtIndex(index);
    return node != null ? node.getData() : null;
  }

  public int indexOf(E data) {
    int index = 0;
    for(Node<E> node = head.getNext(); node != tail; node = node.getNext()) {
      if (node.getData() == data) {
        return index;
      }
      index++;
    }
    return -1;
  }

  public boolean contains(E data) {
    return indexOf(data) >= 0 ? true : false;
  }

  public Object[] toArray() {
    Object[] array = new Object[size()];

    int i = 0;
    for (Node<E> node = head.getNext(); node != tail; node = node.getNext()) {
      array[i] = node.getData();
      i++;
    }
    return array;
  }

  private boolean indexInRange(int index) {
    return index >= 0 && index < size();
  }

  private boolean indexInRangeInclusive(int index) {
    return indexInRange(index) || index == size;
  }

  private Node<E> nodeAtIndex(int index) {
    if (!indexInRange(index)){return null;}
    Node<E> node = head.getNext();
    for (int i = 0; i < index; i++) {
      node = node.getNext();
    }
    return node;
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
      if (this.getData() == null) {
        throw new NullPointerException("Cannot insert null node");
      }
      this.setPrev(node.getPrev());
      this.setNext(node);
    }

    private void insertAfterNode(Node<E> node) {
      if (node != tail) {
        this.insertBeforeNode(node.getNext());
      }
    }

    private void removeFromList() {
      assert (this != head && this != tail);

      prev.setNext(next);
    }
  }
}
