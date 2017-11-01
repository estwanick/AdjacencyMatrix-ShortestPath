public class Main {
    public static void main(String[] args) {
        int V = Integer.parseInt("5");
        Graph G = new Graph(V);
        G.addEdge(1,2, 5);
        G.printAdjMatrix();
    }
}