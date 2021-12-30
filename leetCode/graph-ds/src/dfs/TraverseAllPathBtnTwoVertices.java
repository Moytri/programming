package dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 
 * @author https://leetcode.com/problems/all-paths-from-source-to-target/discuss/412377/Java-Iterative-with-Stack-and-Queue-and-statistics-comparing-Iterative-vs-Recursive-speeds
 * Problem: https://leetcode.com/problems/all-paths-from-source-to-target/
 *
 */
public class TraverseAllPathBtnTwoVertices {

	public static void main(String[] args) {
		TraverseAllPathBtnTwoVertices allPath = new TraverseAllPathBtnTwoVertices();
		allPath.allPathsSourceTarget(new int[][] {
			{1,2},
			{3},
			{3},
			{}
		});
	}
	
	 public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	    Integer end = graph.length - 1;
	    List<List<Integer>> result = new ArrayList<>();
	
	    Deque<Integer> stack = new ArrayDeque<>(); // keep track of nodes to process
	    Deque<Integer> path  = new ArrayDeque<>(); // path generated so far
	    
	    // prime the stack with the start node
	    stack.push(0);
	    
	    while (!stack.isEmpty()) {
	        /* 'hack' alert
	        we need an Integer object and not an int because path.peekLast()
	        will return null the very first time it is called.
	        you cannot compare null with an int but you can with an Integer
			*/
	        Integer current = stack.peek(); /* peek, don't pop */
	        if (current == path.peekLast()) {
	            /*
				   when the top of the stack and the top of queue match
	               it means we have processes all this node's connections
	               there are no more paths to explore so remove the node
	               from the list of nodes to process, and from the path
	               We are backtracking to the previous point in the path, and
	               the list of nodes to process
				*/
	            stack.pop();       // remove the end from the path
	            path.removeLast(); // remove the end from the path
	            continue;
	        }
	        path.offer(current);
	        if (current == end) {
	            /* We've found a path */
	            result.add(new ArrayList(path)); /* add the path Queue as a List to the result */
	            path.removeLast(); /* go back one step in the path */
	            stack.pop();       /* remove the from the nodes to process */
	            continue;
	        }
			/*
			   we haven't seen this node before.
	           add all of this node's neighbors to the stack of nodes to process
			*/
	        for (int neighbor : graph[current]) {
	            stack.push(neighbor);
	        }
	    }
	    return result;
	}	

}
