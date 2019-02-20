import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
  private int N;
  private Node first;
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

  public void push(Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    N++;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new StackIterator();
  }

  private class StackIterator implements Iterator<Item> {
    private Node curNode = first;
    public boolean hasNext() {
      return curNode != null;
    }
    public Item next() {
      Item item = curNode.item;
      curNode = curNode.next;
      return item;
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.pop();
    for (int item : stack) {
      System.out.println(item);
    }
  }
}
