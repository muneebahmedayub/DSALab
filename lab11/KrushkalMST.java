package lab11;
import java.util.*; 
public class KrushkalMST {
	public static void main(String[] args) {
		ArrayList<Edge> graphEdges = new ArrayList<Edge>();
		graphEdges.add(new Edge(1, 2, 28));
		graphEdges.add(new Edge(2, 3, 16));
		graphEdges.add(new Edge(2, 7, 14));
		graphEdges.add(new Edge(3, 4, 12));
		graphEdges.add(new Edge(4, 7, 18));
		graphEdges.add(new Edge(4, 5, 22));
		graphEdges.add(new Edge(5, 7, 24));
		graphEdges.add(new Edge(6, 5, 25));
		graphEdges.add(new Edge(6, 1, 10));
		int nodeCount = 7;	
		KrushkalMST graph = new KrushkalMST();	
		graph.kruskalMST(graphEdges, nodeCount);
	}
	public void kruskalMST(ArrayList<Edge> graphEdges,
			int nodeCount){
		String outputMessage="";
		Collections.sort(graphEdges);		//sort edges with smallest weight 1st
		ArrayList<Edge> mstEdges = new ArrayList<Edge>();	//list of edges included in the Minimum spanning tree (initially empty)
		DisjointSet nodeSet = new DisjointSet(nodeCount+1);		//Initialize singleton sets for each node in graph. (nodeCount +1) to account for arrays indexing from 0
		for(int i=0; i<graphEdges.size() && mstEdges.size()
				<(nodeCount-1); i++){		//loop over all edges. Start @ 1 (ignore 0th as placeholder). Also early termination when number of edges=(number of nodes-1)
			Edge currentEdge = graphEdges.get(i);
			int v1 = nodeSet.find(currentEdge.getVertex1());		//Find root of 1 vertex of the edge
			int v2 = nodeSet.find(currentEdge.getVertex2());
	outputMessage+="find("+currentEdge.getVertex1()+") "
	+ "returns "+v1+", find("+currentEdge.getVertex2()+") "
	+ "returns "+v2;		//just print, keep on same line for union message
			String unionMessage=",\tNo union performed\n";		//assume no union is to be performed, changed later if a union DOES happen
			if(v1 != v2){			//if roots are in different sets the DO NOT create a cycle
				mstEdges.add(currentEdge);		//add the edge to the graph
				nodeSet.union(v1, v2);	//union the sets
				unionMessage=",\tUnion("+v1+", "+v2+") done\n";		//change what's printed if a union IS performed
			}
			outputMessage+=unionMessage;
		}
		outputMessage+="\nFinal Minimum Spanning Tree "
				+ "("+mstEdges.size()+" edges)\n";
		int mstTotalEdgeWeight=0;
		for(Edge edge: mstEdges){
			outputMessage+=edge +"\n";		//print each edge
			mstTotalEdgeWeight += edge.getWeight();
		}
		outputMessage+="\nTotal weight of all edges in MST = "
		+mstTotalEdgeWeight;
		System.out.println(outputMessage);

	}
}
class Edge implements Comparable<Edge>{
	private int vertex1;	//an edge has 2 vertices & a weight
	private int vertex2;
	private int weight;

	public Edge(int vertex1, int vertex2, int weight){
		this.vertex1=vertex1;
		this.vertex2=vertex2;
		this.weight=weight;
	}
	public int getVertex1(){
		return vertex1;
	}
	public int getVertex2(){
		return vertex2;
	}

	public int getWeight(){
		return weight;
	}

	@Override
	public int compareTo(Edge otherEdge) {				//Compare based on edge weight (for sorting)
		return this.getWeight() - otherEdge.getWeight();
	}

	@Override
	public String toString() {
		return "Edge ("+getVertex1()+", "+getVertex2()+") weight="+getWeight();
	}
}

class DisjointSet{
	private int[] set;		//the disjoint set as an array

	public int[] getSet(){		//mostly debugging method to print array
		return set;
	}
	public DisjointSet(int numElements) {		//constructor creates singleton sets
		set = new int [numElements];
		for(int i = 0; i < set.length; i++){		//initialize to -1 so the trees have nothing in them
			set[i] = -1;
		}
	}

	public void union(int root1, int root2) {
		if(set[root2] < set[root1]){		// root2 is deeper
			set[root1] = root2;		// Make root2 new root
		}
		else {
			if(set[root1] == set[root2]){
				set[root1]--;			// Update height if same
			}
			set[root2] = root1;		// Make root1 new root
		}
	}
	public int find(int x) {
		if(set[x] < 0){		//If tree is a root, return its index
			return x;
		}
		int next = x;		
		while(set[next] > 0){		//Loop until we find a root
			next=set[next];
		}
		return next;
	}
	
}