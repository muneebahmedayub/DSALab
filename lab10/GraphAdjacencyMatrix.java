package lab10;
import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;
public class GraphAdjacencyMatrix{
static class Graph
{	int v;
	int e;
	int[][] adj;
	Graph(int v, int e)
	{
		this.v = v;
		this.e = e;
		adj = new int[v][v];
		for(int row = 0; row < v; row++)
			Arrays.fill(adj[row], 0);
	}
	void addEdge(int start, int e)
	{
		adj[start][e] = 1;
		adj[e][start] = 1;
	}
	void BFS(int start)
	{
		boolean[] visited = new boolean[v];
		Arrays.fill(visited, false);
		List<Integer> q = new ArrayList<>();
		q.add(start);
		visited[start] = true;
		int vis;
		while (!q.isEmpty())
		{
			vis = q.get(0);
			System.out.print(vis + " ");
			q.remove(q.get(0));
			for(int i = 0; i < v; i++)
			{
				if (adj[vis][i] == 1 && (!visited[i]))
				{
					q.add(i);
					visited[i] = true;
				}}}}
	void DFS(int start, boolean[] visited)
	{
	    System.out.print(start + " ");
	    visited[start] = true;
	    for (int i = 0; i < adj[start].length; i++) {
	        if (adj[start][i] == 1 && (!visited[i])) {
	            DFS(i, visited);
	        }}}}
public static void main(String[] args)
{	int v = 5, e = 4;
	Graph G = new Graph(v, e);
	G.addEdge(0, 1);
	G.addEdge(0, 2);
	G.addEdge(1, 3);
	G.BFS(0);
	boolean[] visited = new boolean[v];
	System.out.println();
	G.DFS(0, visited);
}}
