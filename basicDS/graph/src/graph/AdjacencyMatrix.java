package graph;

public class AdjacencyMatrix {
	
	int numberOfNodes ;
	int [][] graph;
	
	public static void main (String [] args) {
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		matrix.addEdge();
	}
	
	public void addEdge() {
		String graphDetails [] = {"3","3", "0 1", "0 2", "1 2"};
		
		numberOfNodes = Integer.parseInt(graphDetails[0]);
		graph = initGraph(numberOfNodes);
		int length = graphDetails.length;
		int startIndex = 2;
		
		while (startIndex < length) {
			String edge = graphDetails[startIndex];
			String edges [] = edge.split(" ");
			
			graph[Integer.parseInt(edges[0])][Integer.parseInt(edges[1])]= 1;
			startIndex++;
		}
		 
		printGraph(graph, numberOfNodes);
	}
	
	// initialize the matrix with 0, we will update the edges with 1
	private int [][] initGraph(int numberOfNodes) {
		int graph [][] = new int[numberOfNodes][numberOfNodes];
		
		for (int i = 0; i < numberOfNodes; i++) {
			for (int j = 0; j < numberOfNodes; j++) {
				graph[i][j] = 0;
			}
		}
		return graph;
	}
	
	private void printGraph(int [][] graph, int numberOfNodes) {
		System.out.println("Graph: (Adjacency Matrix)");
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j <numberOfNodes ; j++) {
                System.out.print(graph[i][j]+ " ");
            }
            System.out.println();
        }
        for (int i = 0; i < numberOfNodes; i++) {
            System.out.print("Vertex " + i + " is connected to:");
            for (int j = 0; j <numberOfNodes ; j++) {
                if(graph[i][j]==1){
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
	}
}
