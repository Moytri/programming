package graph;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import graph.Prims.Entry;

public class ShortestPath {
	static LinkedList ls[];
	static boolean visited [];
	static int w[];
	private static Scanner scan = new Scanner(System.in);
	static PriorityQueue<Pair> queue;
	
	//create constructor
	ShortestPath(int vertices) {
		ls = new LinkedList[vertices];
		visited = new boolean[vertices];
		w = new int[vertices];
		queue = new PriorityQueue<>(vertices,
				new Comparator<Pair>() {

					@Override
					public int compare(Pair o1, Pair o2) {
						return o2.weight.compareTo(o1.weight);
					}
				} );
		
		for(int i = 0; i < vertices; i++) {
			ls[i] = new LinkedList<Integer>();
			visited[i] = false;
			w[i] = Integer.MAX_VALUE;
		}
	}
	
	public static void dijkstra(int src) {
		//initially src weight is assigned 0
		w[src] = 0;
		queue.offer(new Pair(src, 0)); //add into the queue
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll(); //poll from the queue 
			visited[pair.node] = true; //make the node visited after removal from the queue
			
			//got through all the adjacency node from the removed node
			//get the weightedSum (parent weight + weight between parent and its adjacent node)
			//check if the node is unvisited and its weightedSum < its weight; update the weight with weightedSum
			//insert into queue, but all time less weight will be inserted first
			for(int i = 0; i < ls[pair.node].size(); i++) {
				int neighbour = ((Details) ls[pair.node].get(i)).target;
				int weightSum = pair.weight + ((Details) ls[pair.node].get(i)).weight;

				if(visited[neighbour] == false && weightSum < w[neighbour]) {
					w[neighbour] = weightSum;
					queue.offer(new Pair(neighbour, weightSum));
				}
			}
		}
		printDijkstra(w, src);
	}
	

	private static void printDijkstra(int[] weight, int src) {
		System.out.println("Dijkstra Algorithm: (Adjacency List + Priority Queue)");
        for (int i = 0; i <weight.length ; i++) {
            System.out.println("Source Vertex: " + src + " to vertex " +   + i +
                    " distance: " + w[i]);
        }
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of vertices: ");
		int vertices = scan.nextInt();
		
		System.out.println("Enter the number of edges : ");
		int edges = scan.nextInt();
		scan.nextLine();
		
		ShortestPath graph = new ShortestPath(vertices);
		
		System.out.println("Enter list of edges: ");
		for(int i = 0; i<edges; i++) {
			String[] vals = scan.nextLine().trim().split("\\s+");
			graph.add(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]), Integer.parseInt(vals[2]));
		}

		dijkstra(0);
	}
	
	//insert data into graph
	private void add(int src, int dest, int weight) {
		ls[src].add(new Details(dest, weight));
	}
	
	//print the graph
	public void print() {
		for(int i = 0; i < ls.length; i++) {
			System.out.print(i + " : ");
			for(int j = 0; j < ls[i].size(); j++) {
				System.out.print(((Entry) ls[i].get(j)).getDest() + " : " + ((Entry) ls[i].get(j)).getWeight() + " ");
			}
			System.out.println();
		}
	}
	
	//this class is used to store node and weight in the priority queue.
	//the weight of less priority will be inserted first based on given comparator
	static class Pair {
		int node;
		Integer weight;
		Pair(int node, int weight) {
			this.node = node;
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