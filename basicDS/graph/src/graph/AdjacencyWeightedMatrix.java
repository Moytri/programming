package graph;

public class AdjacencyWeightedMatrix {
	int numberOfNodes ;
	int [][] graph;
	
	public static void main (String [] args) {
		AdjacencyWeightedMatrix matrix = new AdjacencyWeightedMatrix();
		matrix.addEdge();
	}
	
	public void addEdge() {
		//input for dijsktra
		//String graphDetails [] = {"5","6", "0 1 9", "0 2 6", "0 3 5", "0 4 3", "2 1 2", "2 3 4"};
		
		//input for BellmanFord
		String graphDetails [] = {"5","8", "0 1 -1", "0 2 4", "1 2 3", "1 3 2", "1 4 2", "3 2 5", "3 1 1", "4 3 -3"};
		
		numberOfNodes = Integer.parseInt(graphDetails[0]);
		graph = initGraph(numberOfNodes);
		int length = graphDetails.length;
		int startIndex = 2;
		
		while (startIndex < length) {
			String edge = graphDetails[startIndex];
			String edges [] = edge.split(" ");
			
			graph[Integer.parseInt(edges[0])][Integer.parseInt(edges[1])]= Integer.parseInt(edges[2]);
			startIndex++;
		}
		 
		printGraph(graph, numberOfNodes);
	}
	
	// initialize the matrix with 0, we will update the edges with 1
	private int [][] initGraph(int numberOfNodes) {
		int graph [][] = new int[numberOfNodes][numberOfNodes];
		
		for (int i = 0; i < numberOfNodes; i++) {
			for (int j = 0; j < numberOfNodes; j++) {
				graph[i][j] = Integer.MAX_VALUE;
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
                if(graph[i][j]!= Integer.MAX_VALUE){
                    System.out.print(" " + j + " and weight is " + graph[i][j]);
                }
            }
            System.out.println();
        }
	}
}
