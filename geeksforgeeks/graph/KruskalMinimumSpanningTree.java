package geeksGraph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KruskalMinimumSpanningTree {

	static ArrayList<Edge> allEdges = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	static boolean printed [];
	static boolean visited [];
	static int vertices;
	
	KruskalMinimumSpanningTree(int vertices) {
		this.vertices = vertices;
		printed = new boolean[vertices];
		visited = new boolean[vertices];
		
		for(int i = 0; i < vertices; i++) {
			printed[i] = false;
			visited[i] = false;
		}
	}
	
	public void kruskal(ArrayList<Edge> ls) {
		Queue<Edge> queue = new PriorityQueue<>(ls.size(),
				new Comparator<Edge>() {
					@Override
					public int compare(Edge o1, Edge o2) {
						return o1.weight - o2.weight;
					}
				});
		
		for(int i = 0; i < ls.size(); i++) {
			queue.add(ls.get(i));
		}
		
		/*//if want to ensure that Queue is sorted according to edge, uncomment this loop
		while(!queue.isEmpty()) {
			Edge e = queue.poll();
			System.out.println(e.src + " " + e.dest + " " + e.weight + " ");
		}*/
		
		int i = 0;
		while(!queue.isEmpty()) {
			Edge edge = queue.poll();
			int src = edge.src;
			int dest = edge.dest;
			if(visited[src] && visited[dest]) continue;
			else {
				System.out.println("Edge-" + i++ + " source: " + src +
                        " destination: " + dest +
                        " weight: " + edge.weight);
				visited[src] = true;
				visited[dest] = true;
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the number of Vertices: ");
		KruskalMinimumSpanningTree graph = new KruskalMinimumSpanningTree(scan.nextInt());
		
		System.out.println("Enter the number of Edges: ");
		int edges = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter Edges: ");
		for(int i = 0; i < edges; i++) {
			String [] edge = scan.nextLine().split(" ");
			Edge myEdgeOne = new Edge(Integer.parseInt(edge[0]), Integer.parseInt(edge[1]),
					Integer.parseInt(edge[2]));
			Edge myEdgeTwo = new Edge(Integer.parseInt(edge[1]), Integer.parseInt(edge[0]),
					Integer.parseInt(edge[2]));
			allEdges.add(myEdgeOne);
			allEdges.add(myEdgeTwo);
		}
		printGraph(allEdges);
		System.out.println();
		System.out.println("Minimum Spanning Tree: ");
		graph.kruskal(allEdges);
	}
	
	public static void printGraph(ArrayList<Edge> ls) {
		for(int i = 0; i < ls.size(); i++) {
			int src = ls.get(i).src;
			if(!printed[src]) {
				System.out.println();
				System.out.print(src + " : ");
			}

			for(int j = 0; j < ls.size(); j++) {
				if(!printed[src] && ls.get(j).src == src) {
					System.out.print(ls.get(j).dest + " - > " + ls.get(j).weight + "  ");
				}
			}
			printed[src] = true;
		}
	}
	
	static class Edge {
		int src;
		int dest;
		int weight;
		
		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

}

/*Output:
	
	Enter the number of Vertices: 
		6
		Enter the number of Edges: 
		7
		Enter Edges: 
		0 1 4
		0 2 3
		1 2 1
		1 3 2
		2 3 4
		3 4 2
		4 5 6

		0 : 1 - > 4  2 - > 3  
		1 : 0 - > 4  2 - > 1  3 - > 2  
		2 : 0 - > 3  1 - > 1  3 - > 4  
		3 : 1 - > 2  2 - > 4  4 - > 2  
		4 : 3 - > 2  5 - > 6  
		5 : 4 - > 6  
		Minimum Spanning Tree: 
		Edge-0 source: 1 destination: 2 weight: 1
		Edge-1 source: 3 destination: 1 weight: 2
		Edge-2 source: 3 destination: 4 weight: 2
		Edge-3 source: 0 destination: 2 weight: 3
		Edge-4 source: 5 destination: 4 weight: 6
*/
