package Lab11;

import java.util.ArrayList;
import java.util.List;

public class Lab11 {
    public static void main(String[] args) {
        dijkstra();
    }

    public static void mstPrims() {
        MSTPrims t = new MSTPrims();
        int graph[][] = new int[][]{
            {0, 28, 0, 0, 0, 10, 0},
            {28, 0, 16, 0, 0, 0, 14},
            {0, 16, 0, 12, 0, 0, 0},
            {0, 0, 12, 0, 22, 0, 18},
            {0, 0, 0, 22, 0, 25, 24},
            {10, 0, 0, 0, 25, 0, 0},
            {0, 14, 0, 18, 24, 0, 0}
        };
        t.primMST(graph);
    }

    public static void graphAdjacencyList() {
        GraphAdjacencyList g = new GraphAdjacencyList(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
        g.DFSY(2);
        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");
        g.BFS(2);
    }

    public static void dijkstra() {
        int V = 5;
        int source = 0;
        List<List<Node>> adj = new ArrayList<List<Node>>();
        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }
        adj.get(0).add(new Node(1, 9));
        adj.get(0).add(new Node(2, 6));
        adj.get(0).add(new Node(3, 5));
        adj.get(0).add(new Node(4, 3));
        adj.get(2).add(new Node(1, 2));
        adj.get(2).add(new Node(3, 4));
        Dijkstra dijkstra = new Dijkstra(V);
        dijkstra.dijkstra(adj, source);
        dijkstra.print();
    }
}
