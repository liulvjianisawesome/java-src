public class BellManFordSP {
  private double[] distTo;
  private DirectedEdge[] edgeTo;
  private boolean[] onQ;
  private Queue<Integer> queue;

  public BellManFordSP(EdgeWeightedDigraph G, int s) {
    distTo = new double[G.V()];
    edgeTo = new DirectedEdge[G.V()];
    onQ = new boolean[G.V()];
    queue = new Queue<>();
    for (int v = 0; v < G.V(); v++) {
      distTo[v] = Double.POSITIVE_INFINITY;
    }
    distTo[s] = 0.0;
    queue.enqueue(s);
    onQ[s] = true;

    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      onQ[v] = false;
      relax(G, v);
    }
  }

  private void relax(EdgeWeightedDigraph G, int v) {
    for (DirectedEdge e : G.adj(v)) {
      int w = e.to();
      if (distTo[w] > distTo[v] + e.weight()) {
        distTo[w] = distTo[v] + e.weight();
        edgeTo[w] = e;
        if (!onQ[w]) {
          queue.enqueue(w);
          onQ[w] = true;
        }
      }
    }
  }
}
