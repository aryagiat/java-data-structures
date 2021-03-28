import java.util.NoSuchElementException;

/**
 * LinkedList Data Structure.
 *
 * @param <T> The type of the items in the linked list.
 */
class LinkedList<T> {
  /**
   * The Node class.
   */
  private class Node {
    T value;
    Node next;

    public Node(T value) {
      this.value = value;
      this.next = null;
    }

    public String toString() {
      return "[" + value + "]->" + next;
    }
  }
  
  private int size;
  private Node first;
  private Node last;

  public LinkedList() {
    this.size = 0;
    this.first = null;
    this.last = null;
  }

  /**
   * Checks whether the linked list is empty.
   *
   * @return True if the LinkedList is empty, False otherwise.
   */
  public boolean isEmpty() {
    return this.first == null;
  }

  /**
   * Gets the size of the linked list.
   *
   * @return The number of elements in the linked list.
   */
  public int size() {
    return this.size;
  }

  /**
   * Adds an item to the head of the linked list.
   */
  public void addFirst(T value) {
    Node n = new Node(value);
    if (this.isEmpty()) {
        this.first = n;
        this.last = n;
    } else {
        n.next = first;
        this.first = n;
    }
    size++;
  }

  /**
   * Adds an item to the tail of the linked list.
   */
  public void addLast(T value) {
    Node n = new Node(value);
    if (this.isEmpty()) {
        this.first = n;
        this.last = n;
    } else {
        this.last.next = n;
        this.last = n;
    }
    size++;
  }

  /**
   * Gets the first item of the linked list.
   *
   * @returns The first item of the linked list.
   */
  public T getFirst() {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    } else {
        T val = this.first.value;
        this.first = this.first.next;
        size--;
        return val;
    }
  }

  /**
   * Gets the element at the specified index without removing it.
   *
   * @param index The index of the wanted element.
   * @return The element at the specified index.
   */
  public T get(int index) {
    if (this.isEmpty()) {
        throw new NoSuchElementException();
    } else {
        return get(this.first, index);
    }
  }

  /**
   * Helper function to get the element at the specified index.
   *
   * @param curr The node.
   * @param index The current index.
   * @return The element at the specified index.
   */
  private T get(Node curr, int index) {
    if (curr == null) {
        throw new NoSuchElementException();
    } else if (index == 0) {
        return curr.value;
    } else {
        return get(curr.next, --index);
    }
  }

  public String toString() {
      if (this.isEmpty()) {
        return null;
      }
      return this.first.toString();
  }
}
