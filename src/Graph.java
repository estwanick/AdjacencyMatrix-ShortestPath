/*
    Adjacency Matrix Graph Implementation
 */
public class Graph {
    private int Vertices;
    private int E;
    private int[][] adj;

    public Graph(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.Vertices = V;
        this.E = 0;
        this.adj = new int[V][V];
    }


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

    public void shortestPath(int v1, int v2) {
        shortestPath(v1);
    }

    private int minDistance(int distance[], boolean spSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for(int v = 0; v < Vertices; v++) {
            if(spSet[v] == false && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    private void shortestPath(int src) {
        int distance[] = new int[Vertices];
        boolean spSet[] = new boolean[Vertices];
        int parent[] = new int[Vertices];


        //Initialize all distance to be infinite
        for(int i=0; i < Vertices; i++) {
            parent[0] = -1;
            distance[i] = Integer.MAX_VALUE;
            spSet[i] = false;
        }

        //Distance from source to self is always 1
        distance[src] = 0;

        for(int count = 0; count < Vertices-1; count++) {
            int u = minDistance(distance, spSet);
            spSet[u] = true;
            for(int av = 0; av < Vertices; av++) {
                if(!spSet[av] && adj[u][av] != 0 && distance[u] != Integer.MAX_VALUE &&
                        distance[u] + adj[u][av] < distance[av]) {
                    parent[av] = u;
                    distance[av] = distance[u] + adj[u][av];
                }
            }
        }
        printSolution(distance, parent);
    }

    private void printSolution(int dist[], int parent[]) {
        System.out.println("Vertex\t  Distance\tPath");
        int src = 1;
        for (int i = 1; i < Vertices; i++) {
            System.out.print("\n" + src + "->" + i + "\t\t" + dist[i] + " \t\t");
            printPath(parent, i);
        }
    }

    private void printPath(int parent[], int next) {
        // Base Case : If j is source
        if (parent[next]==-1)
            return;

        printPath(parent, parent[next]);

        System.out.print(" " + next);
    }
}
