/*
    Adjacency Matrix Graph Implementation
 */
public class Graph {
    private int V;
    private int E;
    private int[][] adj;

    public Graph(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        this.adj = new int[V][V];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }


    // add undirected edge v-w
    public void addEdge(int v, int w, int distance) {
        if (adj[v][w] == 0) E++;
        adj[v][w] = distance;
        adj[w][v] = distance;
    }

    public void printAdjMatrix() {
        for (int i = 0; i < adj[0].length - 1; i++) {
            for (int y = 0; y < adj[adj[0].length - 1].length - 1; y++) {
                System.out.print(adj[i][y]);
            }
            System.out.println("");
        }
    }
}
