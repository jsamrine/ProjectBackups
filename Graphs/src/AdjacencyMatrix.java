import java.util.Queue;
import java.util.Stack;
import java.util.*;

public class AdjacencyMatrix {
	private int[][] adjacency;
	private boolean[] marked;

	public AdjacencyMatrix() {
		this.adjacency = new int[10][10];
		
	}

	public AdjacencyMatrix(int aLength) {
		if (aLength < 0)
			return;

		this.adjacency = new int[aLength][aLength];
		
	}

	public AdjacencyMatrix(int[][] Matrix) {
		this.adjacency = Matrix;
	}

	public void addEdge(int X, int Y, int weight) {
		//X and Y correspond to rows and columns of the graph respectively, 
		if (X >= 0 && Y >= 0 && X <= adjacency.length && Y <= adjacency.length) {
			//index is set to weight
			adjacency[X][Y] = weight;
		}
	}

	public void printMatrix() {
		//prints out matrix in standard format
		System.out.print("   ");
		for (int i = 0; i < adjacency.length; i++) {
			System.out.print("V" + (i + 1) + "");
		}
		System.out.println();
		for (int i = 0; i < adjacency.length; i++) {
			System.out.print("V" + (i + 1) + " ");
			for (int j = 0; j < adjacency.length; j++) {
				System.out.print(adjacency[i][j] + " ");

			}
			System.out.println();
		}
	}

	public void printDFS() {
		//creates boolean array to track which vertices have been visited
		marked = new boolean[adjacency.length];
		printDFS(0, marked);
		System.out.println();
	}
	
	//same as above, used for the DFSall method
	public void printDFS(int i) {
		marked = new boolean[adjacency.length];
		printDFS(i, marked);
		System.out.println();
	}

	private void printDFS(int x, boolean[] marked) {
		//first checks if the index has been marked as visited
		if (marked[x] == true) {
			return;
		}
		//prints vertex
		System.out.print("V" + (x+1) +" ");
		//marks index as visited in corresponding index of boolean array
		marked[x] = true;
		for (int i = 0; i < adjacency.length; i++) {
			if (adjacency[x][i] == 1)
				//recursively calls method on each related index for the current index
				printDFS(i, marked);
		}
	}

	public void printBFS() {
		printBFS(0);
	}

	public void printBFS(int x)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		marked = new boolean[adjacency.length];
		//current index is added to queue
		q.add(x);
		int w;
		while (!q.isEmpty()) {
			//w is assigned first element of queue
			w = q.remove();

			System.out.print("V" + (w+1) +" ");
			marked[w] = true;

			for (int i = 0; i < adjacency.length; i++) {
				if (adjacency[w][i] == 1 && marked[i] == false) {
					//for every active index in the row, the index is added to the queue, and marked as visited 
					q.add(i);
					marked[i] = true;
				}
			}
		}
		System.out.println();

	}

	public void printDFSAll() {
		for (int i = 0; i<adjacency.length; i++) {
			printDFS(i);
		}
	}

	public void printBFSAll() {
		for (int i = 0; i<adjacency.length; i++) {
			printBFS(i);
		}
	}
}
