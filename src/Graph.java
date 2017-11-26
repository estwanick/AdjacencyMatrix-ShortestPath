/*
    Adjacency Matrix Graph Implementation
 */
public class Graph {
    private int Vertices;
    private int E;
    private int[][] adj;

    public Graph(int V) {
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");
        this.Vertices = V + 1;
        this.E = 0;
        this.adj = new int[Vertices][Vertices];
    }


    public void addEdge(int v, int w, int distance) {
        if (adj[v][w] == 0) E++;
        adj[v][w] = distance;
        adj[w][v] = distance;
    }

    public void printAdjMatrix() {
        for (int i = 0; i < adj[0].length; i++) {
            for (int y = 0; y < adj[adj[0].length - 1].length; y++) {
                System.out.print(adj[i][y]);
            }
            System.out.println("");
        }
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

    public void shortestPath(int src, int dest) {
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
        printSolution(src, distance, parent, dest);
    }

    private void printSolution(int src, int dist[], int parent[], int dest) {
        System.out.println("Vertex\t  Distance\tPath");
        for (int i = 1; i < Vertices; i++) {
            System.out.println("");
            if(i == dest) {
                System.out.print("*");
            }
            System.out.print(src + "->" + i + "\t\t" + dist[i] + " \t\t");
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
