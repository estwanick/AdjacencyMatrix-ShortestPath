import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        Graph G = new Graph(vertices);

        for(int i = 0; i < vertices; i++) {
            System.out.print("Enter Node 1: ");
            int node1 = sc.nextInt();

            System.out.print("Enter Node 2: ");
            int node2 = sc.nextInt();

            System.out.print("Enter Distance: ");
            int distance = sc.nextInt();
            System.out.print("Entered: Node " + node1 + " is " + distance + " distance from Node " + node2);

            G.addEdge(node1,node2, distance);

            System.out.println();
        }

        System.out.println();
        System.out.println("Adjacency Matrix");
        G.printAdjMatrix();

        System.out.println();
        System.out.println("Shortest Path Search: ");
        System.out.print("Enter Node 1: ");
        int sNode1 = sc.nextInt();
        System.out.print("Enter Node 2: ");
        int sNode2 = sc.nextInt();
        G.shortestPath(sNode1,sNode2);
        System.out.println();

    }
}