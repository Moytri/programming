package graph;

import java.util.HashMap;
import java.util.Map;

public class SPABellmanFord {
	
	int numberOfNodes;
	int [][] graph;
	
	public static void main(String[] args) {
		AdjacencyWeightedMatrix matrix = new AdjacencyWeightedMatrix();		
		SPABellmanFord spa = new SPABellmanFord();
		
		matrix.addEdge();
		spa.numberOfNodes = matrix.numberOfNodes;
		spa.graph = matrix.graph;

		spa.findShortestPath(spa.graph, 0);

	}
	
	public void findShortestPath (int [][] graph, int start) {		
		int [] distance = new int[numberOfNodes];
		Map<Integer, Map<Integer, Integer>> path = new HashMap<>();
		
		for (int i = 0;i < numberOfNodes; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
		
		for (int i = 0; i < numberOfNodes - 1; i++) {
			for (int j = 0; j < numberOfNodes; j++) {
				for (int k = 0; k < numberOfNodes; k++) {
					
					if (graph[j][k] != Integer.MAX_VALUE) {
						int weight = graph[j][k] + distance[j];
						
						if ( weight < distance[k]) {
							distance[k] = weight;
							
							Map<Integer, Integer> relation = new HashMap<>();
							relation.put(j, weight);
							path.put(k, relation);
						}
					} 
				}				
			}
		}
		
		printShortestPath(start, path);
	}
	
	private void printShortestPath(int src, Map<Integer, Map<Integer, Integer>> path) {
		for (Map.Entry<Integer, Map<Integer,Integer>> entry : path.entrySet()) {
			int key = entry.getKey();
			Map<Integer, Integer> val = entry.getValue();
			
			if (val != null) {
				for (Map.Entry<Integer, Integer> value: val.entrySet()) {
					System.out.println("shortest Path from " +  src + " to " + key +" is " + value.getValue());
				}	
			}
			
			
		}
		
	}

}
