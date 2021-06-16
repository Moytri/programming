package graph;

import java.util.*;

class AdjacencyList {
	
	private static Scanner scanner;
	private ArrayList<ArrayList<Integer>> list;
	
	public static void main(String [] args) {
		scanner = new Scanner(System.in);
		
		AdjacencyList adjList = new AdjacencyList();
		adjList.addEdge();
	}
	
	public void addEdge() {
		int nodeNumber = 0;
		int edgeNumber = 0;
		String edges;
		
		System.out.println("Please enter the number of nodes: ");
		nodeNumber = scanner.nextInt();
		list = new ArrayList<>(nodeNumber);
		
		for (int i = 0; i < nodeNumber; i++) {
			list.add(new ArrayList());
		}
		
		System.out.println("Please enter the number of edges: ");
		edgeNumber = scanner.nextInt();
		
		System.out.println("Enter edges: ");
		scanner.nextLine();
		
		while(edgeNumber > 0) {
			edges = scanner.nextLine();
			edgeNumber--;			
			String edgeToInsert []= edges.split(" ");
			
			list.get(Integer.parseInt(edgeToInsert[0])).add(Integer.parseInt(edgeToInsert[1]));
		}
		printGraph(list);		
	}
	
	public void printGraph(ArrayList<ArrayList<Integer>> list) {	
		int vertexCount = list.size();
		for (int i = 0; i < vertexCount; i++) {
		    int edgeCount = list.get(i).size();
		    for (int j = 0; j < edgeCount; j++) {
		        Integer startVertex = i;
		        Integer endVertex = list.get(i).get(j);
		        System.out.printf("Vertex %d is connected to vertex %d%n", startVertex, endVertex);
		    }
		}
	}
	 
}