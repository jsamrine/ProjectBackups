public class AdjMatrixTester {
	public static void main(String[] args) {
		AdjacencyMatrix g = new AdjacencyMatrix(8);
		System.out.println("Adding Edges");

		/*
		 * m.addEdge(0, 3, 1); m.addEdge(1, 3, 1); m.addEdge(2, 0, 1);
		 * m.addEdge(2, 4, 1); m.addEdge(3, 2, 1); m.addEdge(3, 4, 1);
		 * m.addEdge(2, 5, 1); m.addEdge(4, 5, 1); m.addEdge(4, 6, 1);
		 * m.addEdge(4, 6, 1); m.addEdge(0, 1, 1); m.printMatrix();
		 */
		g.addEdge(0, 1, 1);
		g.addEdge(0, 3, 1);
		g.addEdge(0, 5, 1);

		g.addEdge(1, 3, 1);
		g.addEdge(1, 4, 1);

		g.addEdge(2, 7, 1);

		g.addEdge(3, 6, 1);
		g.addEdge(3, 7, 1);

		g.addEdge(4, 2, 1);

		g.addEdge(5, 3, 1);

		g.addEdge(6, 5, 1);
		System.out.println("DFS");
		g.printDFS();
		System.out.println("DFS all");
		g.printDFSAll();
		System.out.println("BFS");
		g.printBFS();
		System.out.println("BFS all");
		g.printBFSAll();
		g.printMatrix();
		
		AdjacencyMatrix g2 = new AdjacencyMatrix(7);
		System.out.println("New Matrix");
		g2.addEdge(0, 1, 1);
		g2.addEdge(0, 3, 1);
		g2.addEdge(1, 3, 1);
		g2.addEdge(2, 0, 1);
		g2.addEdge(2, 4, 1);
		g2.addEdge(3, 2, 1);
		g2.addEdge(3, 4, 1);
		g2.addEdge(4, 6, 1);
		g2.addEdge(4, 5, 1);
		//g2.printMatrix();
		System.out.println("Printing DFS");
		g2.printDFS();
		System.out.println("Printing all DFS"); 
		g2.printDFSAll();
		System.out.println("Printing BFS");
		g2.printBFS();
		System.out.println("Printing all BFS");  
		g2.printBFSAll();

	}
}
