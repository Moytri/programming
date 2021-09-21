package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SPADijsktra {

	int numberOfNodes;
	int [][] graph;
	
	public static void main(String[] args) {
		AdjacencyWeightedMatrix matrix = new AdjacencyWeightedMatrix();		
		SPADijsktra spa = new SPADijsktra();
		
		matrix.addEdge();
		spa.numberOfNodes = matrix.numberOfNodes;
		spa.graph = matrix.graph;

		spa.dijsktra(spa.graph, 0);
	}
	
	public void  dijsktra(int [][] graph, int src) {
		int [] distance = new int[numberOfNodes];
		Map<Integer, Map<Integer, Integer>> path = new HashMap<>();
		PriorityQueue<Data> queue = new PriorityQueue<Data>((a,b) -> a.distance - b.distance);
		
		for (int i = 0; i < numberOfNodes; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		queue.add(new Data(src, 0));
		distance[src] = 0;
		path.put(src, null);
		
		while (!queue.isEmpty()) {
			Data currentData = queue.poll();
			int currentNode = currentData.node;
			
			for (int i = 0; i < numberOfNodes; i++) {
				if (graph[currentNode][i] != Integer.MAX_VALUE) {
					int dist = distance[currentNode] + graph[currentNode][i];
					if (dist < distance[i]) {
						distance[i] = dist;
						Map<Integer, Integer> relation = new HashMap<>();
						relation.put(currentNode, dist);
						path.put(i, relation);
						
						queue.add(new Data(i, dist));
					}
				}
			}
		}
		
		printShortestPath(src, path);
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
	
	class Data {
		int node;
		int distance;
		
		public Data(int node, int distance) {
			this.node = node;
			this.distance = distance;
		}
	}

}
