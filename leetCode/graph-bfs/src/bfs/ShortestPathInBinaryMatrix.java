package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		ShortestPathInBinaryMatrix shortestPath = new ShortestPathInBinaryMatrix();
		System.out.println(shortestPath.shortestPathBinaryMatrix(new int[][] {
			{0, 1},
			{1, 0}
		}));

	}
	
	private static final int directions[][] = new int[][]{
        {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        
        boolean [][] visited = new boolean[grid.length][grid[0].length];
        Queue<Details> queue = new LinkedList<>();
        
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;
        
        return bfs(grid, 0, 0, queue, visited);
    }
    
    public int bfs(int[][] grid, int i, int j, Queue<Details> queue, boolean [][] visited) {
        queue.add(new Details(i, j, 1));
        visited[i][j] = true;
        int directionX = 0;
        int directionY = 0;
        
        while (!queue.isEmpty()) {
            Details current = queue.remove();
            int level = current.level;
            
            directionX = current.i;
            directionY = current.j;

            
            if (directionX == grid.length - 1 && directionY == grid[0].length - 1) {
                return level;
            }
            
            for (int k = 0; k < directions.length; k++) {
                int neighbourX = directionX + directions[k][0];
                int neighbourY = directionY + directions[k][1];
                
                if (neighbourX >= 0 && neighbourX < grid.length &&
                   neighbourY >= 0 && neighbourY < grid[0].length && 
                   grid[neighbourX][neighbourY] == 0 && !visited[neighbourX][neighbourY]) {
                   visited[neighbourX][neighbourY] = true;
                   queue.add(new Details(neighbourX, neighbourY, level + 1));
               }
            }
        }
        return -1;
    }
    
    class Details {
        int i; int j; int level;
        
        public Details(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }	
}
