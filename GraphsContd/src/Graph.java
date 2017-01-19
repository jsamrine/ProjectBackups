import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Graph {
	private class Vertex {
		String name;
		ArrayList<Edge> neighbors;

		public Vertex(String aName) {
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

	private class Edge {
		Vertex nextVert;
		double weight;

		public Edge(Vertex aV1, double aWeight) {
			nextVert = aV1;
			weight = aWeight;
		}

		public Vertex getNextVert() {
			return nextVert;
		}

		public void setNextVert(Vertex nextVert) {
			this.nextVert = nextVert;
		}
	}

	private Vertex origin;
	private ArrayList<Vertex> vertices;
	private ArrayList<Vertex> markedVerts;
	private ArrayList<Vertex> visitedVerts;
	private ArrayList<Edge> traversed;
	private ArrayList<Edge> visitedEdges;
	private int edgeCount;

	public Graph() {
		origin = null;
		vertices = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
		visitedVerts = new ArrayList<Vertex>();
		traversed = new ArrayList<Edge>();
		visitedEdges = new ArrayList<Edge>();
		edgeCount = 0;
	}

	// vertexes have edges linking them to other vertexes
	public void addVertex(String aName) {
		// checks graph to see if a duplicate vertex already exists
		if (!isContained(aName)) {
			Vertex v = new Vertex(aName);
			vertices.add(v);
			if (origin == null) {
				origin = v;
			}
		}

	}

	public boolean isContained(String aName) {
		for (Vertex vert : vertices) {
			// checks for a matching name, returning true if a match is found
			if (vert.name.equals(aName)) {
				return true;
			}
		}
		return false;
	}

	public void addEdge(String fromVert, String toVert, double weight) {
		// two local variables find vertexes in the graph with matching names
		Vertex v1 = getVertex(fromVert);
		Vertex v2 = getVertex(toVert);
		// checks to make sure vertexes are initialized
		if (v1 == null || v2 == null) {
			return;
		}
		//graph is undirected, edge is added to each of the vertexes' neighbors
		v1.neighbors.add(new Edge(v2, weight));
		v2.neighbors.add(new Edge(v1, weight));
		edgeCount++;
	}

	public Vertex getVertex(String aName) {
		// similar to the isContained method, this searches for each vertex in
		// the arraylist
		// with a name that matches aName, returning a vertex
		for (Vertex vert : vertices) {
			if (vert.name.equals(aName)) {
				return vert;
			}
		}
		return null;
	}
	

	public Edge getEdge(Vertex from, Vertex to) {
		//searches for an edge between two vertices. 
		for (Edge edge : from.neighbors) {
			if (edge.nextVert == to) {
				//Im not sure if this statement will get 
				return edge;
			}
		}
		return null;
	}

	public void strollAroundKoningsburg() {
		//Starts from every vertex
		for (Vertex v : vertices) {
			traversed.clear();
			// markedVerts.clear();
			// visitedVerts.clear();
			System.out.println("Starting from: " + v.name);
			//Starts from each vertex
			startFrom(v);
			System.out.println(edgeCount);
			System.out.println(traversed.size());
			System.out.println();
		}
	}

	public void startFrom(Vertex vert) {
		//for each edge that has not been crossed,
		//this method will recursively go through each possible
		//combination of paths to attempt to find its way possible
		//however, this method will only find variations of one path.
		System.out.println(vert.name);
		Queue<Edge> q = new LinkedList<Edge>();
		for (Edge edge : vert.neighbors) {
			// System.out.println("Check");
			if (!traversed.contains(edge) ) {
				//if the list of traversed bridges does not contain the current edge
				//the edge is added to the list of bridges to be traversed. 
				q.add(edge);
				// return;
			}
		}
		//if(!traversed.isEmpty()){traversed.remove(traversed.size()-1);}
		Edge e;
		while (!q.isEmpty()) {
			e = q.remove();
			// System.out.println(e.nextVert.name);
			
			Edge e1 = getEdge(e.nextVert, vert);
			if (!traversed.contains(e) && /*e.nextVert != vert &&*/ !traversed.contains(e1)) {

				System.out.println("Traversing");
				traversed.add(e1);
				//visitedEdges.add(e);
				//visitedEdges.add(e1);
				startFrom(e.nextVert);
				//traversed.remove(traversed.size() -1);
				
				traversed.add(e);
			}

		}
		
		//traversed.remove(traversed.size() -1);
	}
	
	public void printBFS() {
		//clears all arraylists
		markedVerts.clear();
		visitedVerts.clear();
		//prints root and calls helper method
		System.out.println(origin.name);
		printBFS(origin);
	}

	public void printBFS(Vertex vert) {
		//checks if printed or not
		if (markedVerts.contains(vert)) {
			return;
		}
		//vertex is marked
		markedVerts.add(vert);
		
		for (Edge edge : vert.neighbors) {
			//for each edge, if it has not been marked or visited, the name is printed
			//the next vertex of each edge is marked as visited
			if (!visitedVerts.contains(edge.nextVert) || !markedVerts.contains(vert)) {
				System.out.println(edge.nextVert.name);
				visitedVerts.add(edge.nextVert);
			}
			
		}
		//for each edge in the current vertex's list of neighbors, the printBFS method is called
		for (Edge edge : vert.neighbors) {
			printBFS(edge.nextVert);
		}
	}
	
	
	public void eulerCircuitProof()
	{
		int edges=0, oddDegrees=0;
		
		for(Vertex v : vertices)
		{
			//for each vertex, its number of edges is counted.
			edges = v.neighbors.size();
			//if the number of edges are odd, the amount of vertexes with odd degrees is incremeneted by one.
			if(edges%2!=0)
			{
				oddDegrees++;
			}
		}
		//because each vertex must have a way for someone to exit the node 
		if(oddDegrees>2)
		{
			System.out.println("No Eulerian Circuit found");
		}
		else
		{
			System.out.println("Eulerian Circuit found");
		}
	}		
	
}
