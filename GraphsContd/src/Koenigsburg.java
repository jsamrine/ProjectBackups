
public class Koenigsburg {

	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("V1");
		g.addVertex("V2");
		g.addVertex("V3");
		g.addVertex("V4");
		
		g.addEdge("V1", "V2", 1);
		g.addEdge("V1", "V2", 2);
		g.addEdge("V1", "V4", 3);
		g.addEdge("V2", "V3", 4);
		g.addEdge("V2", "V3", 5);
		g.addEdge("V2", "V4", 6);
		
		g.addEdge("V3", "V4", 7);
		System.out.println("Taking a walk");
		g.strollAroundKoningsburg();
		//g.printBFS();
		g.eulerCircuitProof();
		/* Note: While I cannot prove it by showing how all 
		 * possible paths cannot cross all bridges and return to the start
		 * I know Euler's proof that if there are more than two vertices with odd
		 * numbered amount of edges, a eulerian circuit cannot be completed for the graph 
		 */
	}

}
