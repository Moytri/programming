package graph;

import java.util.*;

public class GraphBFS {

	int nodes;
	boolean visited [];
	Queue<Integer> queue;
	int [][] graph;
	
	public static void main(String[] args) {
		AdjacencyMatrix matrix = new AdjacencyMatrix();
		GraphBFS bfs = new GraphBFS();
		
		matrix.addEdge();
		bfs.graph= matrix.graph;
		bfs.nodes= matrix.numberOfNodes;
		bfs.bfs(0);
	}
	
	public void bfs(int start) {
		visited = new boolean[nodes];
		queue = new LinkedList<>();
		
		visited[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int data = queue.poll();
			
			System.out.print(data + " ");
			
			for (int i = 0; i < nodes; i++) {
				if (graph[data][i] == 1 && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
