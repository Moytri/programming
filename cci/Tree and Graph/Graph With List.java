package ccigraphtree;

import java.util.LinkedList;
import java.util.Scanner;

public class GraphWithList {

	public static LinkedList<Integer> [] ls;
	
	@SuppressWarnings("unchecked")
	GraphWithList(int vertices) {
		ls = new LinkedList[vertices];
		for(int i = 0; i < ls.length; i++) {
			ls[i] = new LinkedList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int vertices = scan.nextInt();
		
		GraphWithList graph = new GraphWithList(vertices);
		int edges = scan.nextInt();
		scan.nextLine();
		
		for(int i = 0; i < edges; i++) {
			String [] values = scan.nextLine().split(" ");
			add(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
		}		
		print();
	}
	
	public static void add(int src, int dest) {
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
