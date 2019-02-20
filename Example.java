public class Example {
//  public static void sort(Comparable[] a) {
//    int N = a.length;
//    for(int i = 0; i < N; i++) {
//      int min = i;
//      for (int j = i + 1; j < N; j++) {
//        if (less(a[j], a[min]))
//          min = j;
//      }
//      exch(a, i, min);
//    }
//  }
//  public static void sort(Comparable[] a) {
//    int N = a.length;
//    for (int i = 1; i < N; i++) {
//      for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
//        exch(a, j, j-1);
//    }
//  }
//  public static void sort(Comparable[] a) {
//    int N = a.length;
//    int h = 1;
//
//    while(h < N/3) {
//      h = 3 * h + 1;
//    }
//
//    while(h >=1) {
//      for (int i = h; i < N; i++) {
//        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
//          exch(a, j, j-h);
//        }
//      }
//      h = h/3;
//    }
//  }

  private static void merge(Comparable[] a, int lo, int mid, int hi) {
    Comparable[] aux = new Comparable[a.length];
    int i = lo, j = mid + 1;

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[i], aux[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = aux[j++];
      }
    }
  }

  public static void sort(Comparable[] a) {
    sort(a, 0, a.length - 1);
  }

  public static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
  }

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

  private static void show(Comparable[] a) {
    for (int i = 0; i < a.length; i++) {
      System.out.print(a[i] + " ");
    }
  }

  public static boolean isSorted(Comparable[] a) {
    for (int i = 1; i < a.length; i++) {
      if (less(a[i], a[i]))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Integer[] a = {8, 5, 2, 4, 11, 87, 98, 32, 19};
    sort(a);
    assert isSorted(a);
    show(a);
  }
}
