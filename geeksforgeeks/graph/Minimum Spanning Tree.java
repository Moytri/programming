package geeksGraph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MinimumSpanningTree {
	@SuppressWarnings("rawtypes")
	static LinkedList ls[];
	static boolean visited [];
	static int weight [];
	static int parent [];
	private static Scanner scan = new Scanner(System.in);
	static Queue<Pair> queue;
	
	public MinimumSpanningTree (int vertices) {
		ls = new LinkedList[vertices];
		visited = new boolean[vertices];
		weight = new int[vertices];
		parent = new int[vertices];
		queue = new PriorityQueue<>(vertices, new Comparator<Pair>(){			
			@Override
			public int compare(Pair c1, Pair c2) {
	            return (int) (c1.getWeight() - c2.getWeight());
	        }
		});
		
		for(int i = 0; i < vertices; i++) {
			ls[i] = new LinkedList();
			visited[i] = false;
			parent[i] = -1;
			weight[i] = Integer.MAX_VALUE;			
		}
	}
	
	public void prims(LinkedList ls[]) {
		weight[0] = 0;
		queue.add(new Pair(0,0));
		
		while(!queue.isEmpty()) {
			System.out.println(queue.peek().node + " : " + queue.peek().weight);
			Pair extractedPair = queue.poll(); //poll from the queue 
			int extractedVertex = extractedPair.node;
			visited[extractedVertex] = true;
			
			for(int i = 0; i < ls[extractedVertex].size(); i++) {
				int neighbour = ((Details) ls[extractedPair.node].get(i)).target;
				int neighbourWeight = ((Details) ls[extractedPair.node].get(i)).weight;
				
				if(visited[neighbour] == false && neighbourWeight < weight[neighbour]) {
					weight[neighbour] = neighbourWeight;
					parent[neighbour] = extractedVertex;
					queue.add(new Pair(neighbour, weight[neighbour]));
				}
			}
		}
		printMST(parent);
	}
	
	private void printMST(int[] parent) {
		int totalMinWeight = 0;
	    System.out.println("Minimum Spanning Tree: ");
		for(int i = 1; i < visited.length; i++) {
	        System.out.println("Edge: " + parent[i] + " - " + i +
                    " weight: " + weight[i]);
	        totalMinWeight += weight[i];
        }
        System.out.println("Total minimum weight: " + totalMinWeight);
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of vertices: ");
		int vertices = scan.nextInt();
		
		System.out.println("Enter the number of edges : ");
		int edges = scan.nextInt();
		scan.nextLine();
		
		MinimumSpanningTree graph = new MinimumSpanningTree(vertices);
		System.out.println("Enter list of edges: ");
		for(int i = 0; i<edges; i++) {
			String[] vals = scan.nextLine().trim().split("\\s+");
			graph.add(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]), Integer.parseInt(vals[2]));
		}
		graph.print();
		graph.prims(ls);
	}
	
	//insert data into graph
		@SuppressWarnings("unchecked")
		private void add(int src, int dest, int weight) {
			ls[src].add(new Details(dest, weight));
			ls[dest].add(new Details(src, weight));
		}
		
		//print the graph
		public void print() {
			for(int i = 0; i < ls.length; i++) {
				System.out.print(i + " : ");
				for(int j = 0; j < ls[i].size(); j++) {
					System.out.print(((Details) ls[i].get(j)).target + " : " + ((Details) ls[i].get(j)).weight + " ");
				}
				System.out.println();
			}
		}
		
		//this class is used to store node and weight in the priority queue.
		//the weight of less priority will be inserted first based on given comparator
		static class Pair {
			int node;
			int weight;
			Pair(int node, int weight) {
				this.node = node;
				this.weight = weight;
			}
			public int getNode() {
				return node;
			}
			public void setNode(int node) {
				this.node = node;
			}
			public int getWeight() {
				return weight;
			}
			public void setWeight(int weight) {
				this.weight = weight;
			}			
		}
		
		//this class is used to create graph using adjacency list
		//for every source a Details Object is inserted into the list containing target and weight from the source
		static class Details {
			int target;
			int weight;
			Details(int target, int weight) {
				this.target = target;
				this.weight = weight;
			}
		}	

}
