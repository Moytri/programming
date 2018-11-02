package geeksGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSort {
	static LinkedList [] ls;
	static Scanner scan = new Scanner(System.in);
	static boolean visited [];
	static List<Integer> sortedLs = new ArrayList<>();
	
	public TopologicalSort(int vertices) {
		ls = new LinkedList[vertices];
		visited = new boolean[vertices];
		
		for(int i = 0; i < ls.length; i++) {
			ls[i] = new LinkedList<>();
			visited[i] = false;
		}
	}
	
	public static void topologicalSort() {
	   for(int i = 0; i < visited.length; i++) {
		   if(visited[i] == false) {
			   topologicalSort(i);
		   }
	   }
		
		for(int i = sortedLs.size() - 1 ; i >= 0; i--) {
			System.out.print(sortedLs.get(i) + " ");
		}
	}
	
	private static void topologicalSort(int node) {
		visited[node] = true;
		for(int i = 0; i < ls[node].size(); i++) {
			if(visited[(int) ls[node].get(i)] == false) {
				topologicalSort((int) ls[node].get(i));
			}
		}		
		sortedLs.add(node);
	}

	public static void main(String[] args) {
		System.out.println("Enter the number of vertices: ");
		int vertices = scan.nextInt();
		System.out.println("Enter the nmber of edges: ");
		int edges = scan.nextInt();
		scan.nextLine();		
		new TopologicalSort(vertices);
		
		System.out.println("Enter list of edges: ");
		for(int i = 0; i < edges; i++) {
			String [] vals = scan.nextLine().trim().split(" ");
			insert(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]));
		}
		print();
		System.out.println("Topological sort of the graph: ");
		topologicalSort();
	}

	@SuppressWarnings("unchecked")
	public static void insert(int src, int dest) {
		ls[src].add(dest);
	}
	
	public static void print() {
		for(int i = 0; i < ls.length; i++) {
			System.out.print(i + " : ");
			for(int j = 0; j < ls[i].size(); j++) {
				System.out.print(ls[i].get(j) + " ");
			}
			System.out.println();
		}
	}
}