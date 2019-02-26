import java.lang.Object;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
  private Key[] keys;
  private Value[] values;
  private int N;

  public BinarySearchST(int cap) {
    keys = (Key[]) new Comparable[cap];
    values = (Value[]) new Object[cap];
  }

  public int size() {
    return N;
  }

  public boolean isEmpty(Key key) {
    return N == 0;
  }

  public int rank(Key key) {
    int lo = 0, hi = N - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int cmp = key.compareTo(keys[mid]);
      if (cmp < 0) {
        hi = mid - 1;
      }
      if (cmp > 0) {
        lo = mid + 1;
      }
      if (cmp == 0) {
        return mid;
      }
    }
    return lo;
  }

  public Value get(Key key) {
    if (isEmpty(key)) {
      return null;
    }
    int i = rank(key);
    if (i < N && keys[i].compareTo(key) == 0) {
      return values[i];
    } else {
      return null;
    }
  }

  public void put(Key key, Value value) {
    int i = rank(key);
    if (i < N && keys[i].compareTo(key) == 0) {
      values[i] = value;
      return;
    }
    for(int j = N; j > i; j--) {
      keys[j] = keys[j - 1];
      values[j] = values[j - 1];
    }
    keys[i] = key;
    values[i] = value;
    N++;
  }

  public Key min() {
    return keys[0];
  }

  public Key max() {
    return keys[N-1];
  }

  public Key select(int k) {
    return keys[k];
  }

  public Key ceiling(Key key) {
    int i = rank(key);
    return keys[i];
  }

  public Key floor(Key key) {
    int i = rank(key);
    if (i == 0) {
      return null;
    } else {
      return keys[i - 1];
    }
  }
}
