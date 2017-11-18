public class Main {
    public static void main(String[] args) {
        Graph G = new Graph(6);
        G.addEdge(1,2, 5);
        G.addEdge(1,3, 5);
        G.addEdge(1,4, 11);
        G.addEdge(2,5, 1);
        G.addEdge(3,5, 11);
        G.addEdge(4,5, 3);
//        G.printAdjMatrix();
        G.shortestPath(1,5);
    }
}