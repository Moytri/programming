package graph;

import java.util.*;

public class GraphDFS {
	
	int nodes;
	boolean visited [];
	Stack<Integer> stack;
	Set<Integer> set;
	int [][] graph;
	
	public static void main(String[] args) {
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		GraphDFS dfs = new GraphDFS();
		
		matrix.addEdge();
		dfs.graph = matrix.graph;
		dfs.nodes = matrix.numberOfNodes;
		dfs.storeNodes();
		dfs.dfs(0);

	}
	
	public void dfs(int start) {		
		visited = new boolean[nodes];
		stack = new Stack<>();
				
		stack.add(start);
		visited[start] = true;
		
		while(!stack.isEmpty()) {
			int data = stack.pop();
			
			System.out.print(data + " ");
			
			for (int j = 0; j < nodes; j++) {
				
				if (graph[data][j] == 1 && !visited[j]) {
					set.remove(data);
					
					visited[j] = true;
					stack.add(j);
				}
			}
		}
	}
	
	public void storeNodes() {
		set = new HashSet<>();
		for (int i = 0; i < graph.length; i++) {
			set.add(i);
		}
	}
}
