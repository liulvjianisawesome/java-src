import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
  private Node first;
  private class Node {
    Item item;
    Node next;
  }
  public void add(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ListIterator();
  }
  private class ListIterator implements Iterator<Item> {
    private Node currrent = first;
    public boolean hasNext() {
      return currrent != null;
    }
    public Item next() {
      Item item = currrent.item;
      currrent = currrent.next;
      return item;
    }
  }
}
