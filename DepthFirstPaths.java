public class DepthFirstPaths {
  private boolean[] marked;
  private int[] edgeTo;
  private int s;
  public DepthFirstPaths(Graph G, int s) {
    marked = new boolean[G.V()];
    edgeTo = new int[G.V()];
    this.s = s;
    dfs(G, s);
  }
  private void dfs(Graph G, int v) {
    marked[v] = true;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(G, w);
      }
    }
  }
  public boolean hasPathTo(int v) {
    return marked[v];
  }
  Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<Integer>();
    for (int x = v; x != s; x = edgeTo[x]) {
      path.push(x);
    }
    path.push(s);
    return path;
  }
  public static void main(String[] args) {
    Graph G = new Graph(6);
    G.addEdge(0, 5);
    G.addEdge(2, 4);
    G.addEdge(2, 3);
    G.addEdge(1, 2);
    G.addEdge(0, 1);
    G.addEdge(3, 4);
    G.addEdge(3, 5);
    G.addEdge(0, 2);

    int s = 0;
    DepthFirstPaths search = new DepthFirstPaths(G, s);
    for (int v = 0; v < G.V(); v++) {
      System.out.print(s + " to " + v + ": ");
      if (search.hasPathTo(v)) {
        for (int w : search.pathTo(v)) {
          if (w == s) System.out.print(s);
          else System.out.print("-" + w);
        }
      }
      System.out.println();
    }
  }
}
