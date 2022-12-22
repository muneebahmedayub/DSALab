package Lab11;
import java.util.Iterator;
import java.util.LinkedList;

public class GraphAdjacencyList {
    private int V;  // No of vertices
    private LinkedList<Integer> adj[];

    GraphAdjacencyList(int v){
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }
    void addEdge(int v, int w){
        adj[v].add(w); // add w to v's list
    }
    
    void DFSY(int s){
        boolean[] visited = new boolean[V];
        DFS(s, visited);
    }

    void DFS(int s, boolean[] visited){
        visited[s] = true;
        System.out.println(s + " ");
        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if (!visited[n]){
                DFS(n, visited);
            }
        }
    }

    void BFS(int s){
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0){
            s = queue.poll();
            System.out.println(s + " ");
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    
}