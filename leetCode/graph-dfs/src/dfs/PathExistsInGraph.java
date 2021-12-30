package dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/find-if-path-exists-in-graph/
 *
 */
public class PathExistsInGraph {

	public static void main(String[] args) {
		PathExistsInGraph pathExists = new PathExistsInGraph();
		System.out.println(pathExists.validPath(
				3,
				new int [][] {
					{0, 1},
					{1, 2},
					{2, 0}
				},
				0,
				2));
	}
	
	public boolean validPath(int n, int[][] edges, int start, int end) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        boolean [] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        
        while(!stack.isEmpty()) {
            int current = stack.pop();
            
            if (current == end) return true;
            
            List<Integer> ls = adjacencyList.get(current);
            
            for (int i : ls) {
                if (!visited[i]) stack.add(i);
            }
            visited[current] = true;
        }
        
        return false;
    }	
}
