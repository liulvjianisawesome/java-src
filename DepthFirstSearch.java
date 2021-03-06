public class DepthFirstSearch {
  private boolean[] marked;
  private int count;
  public DepthFirstSearch(Graph G, int s) {
    marked = new boolean[G.V()];
    count = 0;
    dfs(G, s);
  }
  private void dfs(Graph G, int v) {
    marked[v] = true;
    count++;
    for (int w : G.adj(v)) {
      if (!marked[w]) {
        dfs(G, w);
      }
    }
  }
}
