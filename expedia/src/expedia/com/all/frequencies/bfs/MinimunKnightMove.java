package expedia.com.all.frequencies.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/minimum-knight-moves/submissions/
 * Note: 1. do time complexity 2. do it using dfs
 *
 */
public class MinimunKnightMove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Solution {
	    public int minKnightMoves(int x, int y) {
	        int[][] offsets = {{1, 2}, {2, 1}, {2, -1}, {1, -2},
	                {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
	        
	        boolean [][] visited = new boolean[607][607];
	        Queue<int[]> queue = new LinkedList<>();
	        queue.add(new int[]{0, 0});
	        int step = 0;
	        
	        while(!queue.isEmpty()) {
	            int currLevelSize = queue.size();
	            
	            for (int i = 0; i < currLevelSize; i++) {
	                int [] curr = queue.poll();

	                if (curr[0] == x && curr[1] == y) return step;
	                
	                 for (int[] offset: offsets) {
	                    int nextX = curr[0] + offset[0];
	                    int nextY = curr[1] + offset[1];

	                    if (!visited[nextX + 302][nextY + 302]) {
	                        visited[nextX + 302][nextY + 302] = true;
	                        queue.add(new int[]{nextX, nextY});
	                    }
	                }                
	            }

	            step++;
	        }
	        
	        return step;
	    }
	}	
}
