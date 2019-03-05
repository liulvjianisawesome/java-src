public class LazyPrimMST {
  private boolean marked[];
  private Queue<Edge> mst;
  private MinPQ<Edge> pq;

  public LazyPrimMST(EdgeWeightedGraph G) {
    marked = new boolean[G.V()];
    mst = new Queue<Edge>();
    pq = new MinPQ<Edge>();

    visit(G, 0);
    while(!pq.isEmpty()) {
      Edge e = pq.delMin();

      int v = e.either(), w = e.other(v);
      if (marked[v] && marked[w]) continue;
      mst.enqueue(e);
      if (marked[v] && !marked[w]) visit(G, w);
      if (marked[w] && !marked[v]) visit(G, v);
    }
  }

  private void visit(EdgeWeightedGraph G, int v) {
    marked[v] = true;
    for (Edge e : G.adj(v)) {
      if (!marked[e.other(v)]) pq.insert(e);
    }
  }
}
