package ccigraphtree;

/*Route Between Nodes: Given a directed graph,
design an algorithm to find out whether 
there is a route between two nodes.*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RouteBetweenNode {

	static boolean [] visited;
	static Queue<Integer> queue = new LinkedList<>();
	static GraphWithList graph;
	static Scanner scan = new Scanner(System.in);
	
	public RouteBetweenNode(int vertices, int edges) {
		visited = new boolean[vertices];
		graph = new GraphWithList(vertices);
		scan.nextLine();
		
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		for(int i = 0; i < edges; i++) {
			String [] values = scan.nextLine().split(" ");
			graph.add(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		}		
		graph.print();
	}
	
	public static void main(String[] args) {		
		RouteBetweenNode route = new RouteBetweenNode(scan.nextInt(), scan.nextInt());
		System.out.println(hasRoute(scan.nextInt(), scan.nextInt()));
	}
	
	public static boolean hasRoute(int src, int dest) {
		visited [ src] = true;
		queue.add(src);
		
		while(!queue.isEmpty()) {
			int data = queue.remove();
			for(int i = 0; i < graph.ls[data].size(); i++) {
				int next = graph.ls[data].get(i);				
				if(dest == next) return true;
				
				if(!visited[next]){
					visited[next] = true;
					queue.add(next);
				}				
			}			
		}
		return false;
	}
}
