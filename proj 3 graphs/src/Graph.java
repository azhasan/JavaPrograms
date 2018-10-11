import java.util.PriorityQueue;
public class Graph<T> {

	private boolean[][] edges; //edges [i][j] is true if there was a vertex from i to j
	private T[] labels; //labels[i] contains the label for vertex i
	private int[][] path;
	private int[] distanceArray;
 
	public Graph()
	{
		this(20);
	}
	
	@SuppressWarnings("unchecked")
	public Graph(int n) 
	{
		edges = new boolean[n][n]; //All values initially falsee
		labels = (T[]) new Object[n]; //All values are initially null
		path = new int[n][n];
		distanceArray = new int[77];
	}
		
	public T getLabel(int vert) 
	{
		return labels[vert];
	}
		
	//test whether an edge exists
	public boolean isEdge(int source, int target)
	{
		return edges[source][target];
	}
		
	public void addEdge(int source, int target)
	{
		edges[source][target] = true;
	}
	
	public void addDistance(int source, int target, int distance) {
		if(edges[source][target] == true) {
			path[source][target] = distance;  
		}
		else
			path[source][target]= 0;
	}
	

	//obtains all the neighbors of the desired vertex
	public int[] neighbors(int vert){
		int i;
		int count = 0;
		int[] answer;
		
		for(i = 0; i< labels.length; i++) {
			if(edges[vert][i]) 
				count++;
		}
		answer = new int[count];
		count = 0;
		for(i = 0; i < labels.length; i++){
			if(edges[vert][i])
				answer[count++] = i;
		}
		return answer;
	}
	
	//remove an edge
	public void removeEdge(int source, int target) {
		edges[source][target] = false;
		if(edges[source][target] == false) {
			path[source][target] = 0;
		}
	}
	
	public void distanceArray(int dist) {
		for(int i = 0; i < distanceArray.length; i++) {
			distanceArray[i] = dist;
		}
	}
	
	public void printdistanceArray() {
		for(int i = 0; i <distanceArray.length; i++) {
			System.out.print(distanceArray[i] + " ");
		}
	}
	
	public int[] dijkstras(Graph<T> g, int source, int target) {
		int[] distance = new int [g.size()];
		int[] pred = new int[g.size()];
		int v = 0;
		boolean[] visited = new boolean[g.size()];
		boolean found = false;
		
		//filling the distances with infinity
		for(int i = 0; i< distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		//sources are 0
		distance[source] = 0;
		
		for(int i = 0; i <distance.length; i++) {
			int next = minVertex(distance, visited);
			visited[next] = true;
			
			int[] n = g.neighbors(next);
			for(int j = 0; j < n.length; j++) { //for each neigher
				 v = n[j];
				int d = distance[next] + g.edgeLength(next, v);
				if(distance[v] > d) {
					distance[v] = d;
					pred[v] = next;
				}
					if(v == target) {
						found = true;
						break;
						
					}
			}
			
		}
		
		if(found) {
			while( v != source) {
				v = pred[v];
			}
			
			return pred;
		}
		
		return pred; 
		
	}

	private int minVertex(int[] dist, boolean[]v) {
		int x = Integer.MAX_VALUE;
		int y = -1; //graph not connected, or no unvisited vertices
		for(int i = 0; i < dist.length; i++) {
			if(!v[i] && dist[i] < x ) {
				y = i;
				x = dist[i];
			}
		}
		return y;
	}
	
	
	public int edgeLength(int source, int target) {
		return path[source][target];
	}
	
	
	//change the label of a vertex of this graph
	public void setLabel(int vert, T newLabel)	{
		labels[vert] = newLabel;
	}
	
	//accessor method to determine the number of vertices
	public int size() 
	{
		return labels.length;
	}
	
	public void displayPath(int distance) {
		for(int i = 0; i < path.length; i++ ) {
			for(int k = 0; k <path[i].length; k++) {
				System.out.print(path[i][k] + " ");
			}
			
			System.out.println();
		}
		
	}
	
	public void displayGraph() {
		
		for(int k = 0; k < 20; k++) {
			System.out.print(k + 1 + "   ");
		}
		System.out.println();
		  
		//displayPath(dist);
		
		System.out.println();
	
		for(int i = 0; i < path.length; i++){
			for(int j = 0; j < path[i].length; j++)	{
				System.out.print(path[i][j] + " ");
			}
			System.out.println();
		}
		
	
	
	}

	




}
