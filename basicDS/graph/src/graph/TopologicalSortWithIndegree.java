package graph;

import java.util.*;

public class TopologicalSortWithIndegree {

	private int [] indegrees;
	private Queue<Integer> nodesWithoutIndegree;
	int nodes;
	int [][] graph;
	
	public static void main(String[] args) {
		// https://www.interviewcake.com/concept/java/topological-sort
		AdjacencyMatrix matrix = new AdjacencyMatrix();		
		TopologicalSortWithIndegree sortedGraph = new TopologicalSortWithIndegree();
		
		matrix.addEdge();
		sortedGraph.nodes = matrix.numberOfNodes;
		sortedGraph.graph = matrix.graph;
		
		sortedGraph.topologicalSort();
	}
	
	// topological sort of the graph
	private void topologicalSort() {
		init();
		indegrees();
		getNoIndegreeNodes();
		
		ArrayList<Integer> outputList = new ArrayList<>();
				
		while (!nodesWithoutIndegree.isEmpty()) {
			int source = nodesWithoutIndegree.poll();			
			
			outputList.add(source);		
			for (int j = 0; j <nodes; j++) {
				if (graph[source][j] == 1) {
					indegrees[j] -= 1;
										
					if (indegrees[j] == 0) {
						nodesWithoutIndegree.add(j);
					}
				}
			}			
			
		}
		
		if (outputList.size() == nodes) {
			printSortedGraph(outputList);
		}
		else {
			System.out.println("No topological ordering exists");
		}
	}
	
	private void init() {
		indegrees = new int[nodes];
		nodesWithoutIndegree = new LinkedList<>();
	}
	
	// calculate indegree
	private int[] indegrees() {		
		for (int i = 0; i < nodes; i++) {
			for (int j = 0; j <nodes; j++) {
				if (graph[i][j] == 1) {
					indegrees[j] += 1;
				}
			}
		}
		return indegrees;
	}
	
	// fetch nodes without indegrees,these nodes will come earlier than any other nodes
	private Queue<Integer> getNoIndegreeNodes() {		
		for (int i = 0; i < nodes; i++) {
			if (indegrees[i] == 0) {
				nodesWithoutIndegree.add(indegrees[i]);
			}
		}
		return nodesWithoutIndegree;
	}
	
	private void printSortedGraph(ArrayList<Integer> list) {
		System.out.println("Topological Order of the adjacency matrix: ");
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}
}
