import java.util.*;

public class Graph {
	private class Vertex {
		String name;
		ArrayList<Edge> neighbors;

		public Vertex(String aName) {
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();
		}
	}

	private class Edge {
		Vertex nextVert;
		double weight;

		public Edge(Vertex aV1, double aWeight) {
			nextVert = aV1;
			weight = aWeight;
		}
	}

	private Vertex origin;
	private ArrayList<Vertex> verticies;
	private ArrayList<Vertex> markedVerts;
	private ArrayList<Vertex> visitedVerts;
	private double maxLength;

	public Graph(double aLength) {
		origin = null;
		verticies = new ArrayList<Vertex>();
		markedVerts = new ArrayList<Vertex>();
		visitedVerts = new ArrayList<Vertex>();
		maxLength = aLength;
	}
	//vertexes have edges linking them to other vertexes
	public void addVertex(String aName) {
		//checks graph to see if a duplicate vertex already exists
		if (!isContained(aName)) {
			Vertex v = new Vertex(aName);
			verticies.add(v);
			if (origin == null) {
				origin = v;
			}
		}

	}

	public boolean isContained(String aName) {
		for (Vertex vert : verticies) {
			//checks for a matching name, returning true if a match is found
			if (vert.name.equals(aName)) {
				return true;
			}
		}
		return false;
	}

	public void addEdge(String fromVert, String toVert, double weight) {
		//two local variables find vertexes in the graph with matching names
		Vertex v1 = getVertex(fromVert);
		Vertex v2 = getVertex(toVert);
		//checks to make sure vertexes are initialized
		if (v1 == null || v2 == null) {
			return;
		}
		v1.neighbors.add(new Edge(v2, weight));
	}

	public Vertex getVertex(String aName) {
		//similar to the isContained method, this searches for each vertex in the arraylist
		//with a name that matches aName, returning a vertex
		for (Vertex vert : verticies) {
			if (vert.name.equals(aName)) {
				return vert;
			}
		}
		return null;
	}

	public void printDFS() {
		//deletes all indexes in the markedVerts array
		markedVerts.clear();
		//calls helper method
		printDFS(origin);
	}

	public void printDFS(Vertex aVert) {
		//if current vertex has been visited/marked, method returns 
		if (markedVerts.contains(aVert)) {
			return;
		}
		//prints out current vertex's name and adds it to the list of marked vertexes
		System.out.println(aVert.name);
		markedVerts.add(aVert);
		//printdfs is called for each edge the vertex has
		for (Edge edge : aVert.neighbors) {
			printDFS(edge.nextVert);
		}
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

	public void printLazyDFS() {
		markedVerts.clear();
		printLazyDFS(origin);
	}

	public void printLazyDFS(Vertex aVert)
	{
		//method is identival to the regular DFS, except that a check
		//is made in the last for each statement comparing the weight 
		//of the edge to the value specified by the max length
		maxLength = 20.0;
		if(markedVerts.contains(aVert))
		{
			return;
		}
		System.out.println(aVert.name);
		markedVerts.add(aVert);
		for(Edge edge: aVert.neighbors)
		{
			if(edge.weight<=maxLength){
				printLazyDFS(edge.nextVert);
			}
		}
	}
}
