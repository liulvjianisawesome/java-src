import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
  private Node first;
  private Node last;
  private int N;
  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  public void enqueue(Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    N++;
  }

  public Item dequeue() {
    Item item = first.item;
    first = first.next;
    if (isEmpty())
      last = null;
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new QueueIterator();
  }

  private class QueueIterator implements Iterator<Item> {
    private Node curNode = first;

    @Override
    public boolean hasNext() {
      return curNode != null;
    }

    @Override
    public Item next() {
      Item item = curNode.item;
      curNode = curNode.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<Integer>();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);
    queue.dequeue();
    for (int item : queue) {
      System.out.println(item);
    }
  }
}
