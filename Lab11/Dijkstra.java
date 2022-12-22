package Lab11;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node() {
    }

    public Node(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2) {
        if (node1.cost < node2.cost) {
            return -1;
        }
        if (node1.cost > node2.cost) {
            return 1;
        }
        return 0;
    }
}

public class Dijkstra {
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Integer> unsettled;
    private int V;
    List<List<Node>> adj;

    public Dijkstra(int V) {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        unsettled = new PriorityQueue<Integer>();
    }

    public int getLength() {
        return dist.length;
    }

    public void dijkstra(List<List<Node>> adj, int src) {
        this.adj = adj;
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        unsettled.add(src);
        dist[src] = 0;
        while (unsettled.size() != 0) {
            int u = unsettled.remove();
            settled.add(u);
            e_Neighbours(u);
        }
    }

    private void e_Neighbours(int u) {
        int edgeDistance = -1;
        int newDistance = -1;
        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);
            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;
                if (newDistance < dist[v.node]) {
                    dist[v.node] = newDistance;
                }
                unsettled.add(v.node);
            }
        }
    }

    public void print() {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

}
