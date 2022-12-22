package Lab11;

public class MSTPrims {
    private static final int V = 7;
    int minKey(int key[], Boolean mstSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++){
            if (mstSet[v] == false && key[v] < min){
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    void printMST(int parent[], int graph[][]){
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    void primMST(int graph[][]){
        int parent[] = new int[V];
        int key[] = new int[V];
        Boolean mstSet[] = new Boolean[V];
        for (int i = 0; i < V; i++){
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++){
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++){
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }

    public static void main(String[] args){
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
}
