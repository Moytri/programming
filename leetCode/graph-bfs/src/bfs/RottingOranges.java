package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {
		RottingOranges rottingOranges = new RottingOranges();
		
		int[][] grid = new int[][] {
			{2,1,1},
			{1,1,0},
			{0,1,1}
		};
		
		System.out.println(rottingOranges.orangesRotting(grid));
	}
	
	int [] dx = {0, 1, 0, -1};
    int [] dy = {1, 0, -1, 0};
    Queue<Pair> queue;
    int count = -1;
    boolean[][] visited;
    
    public int orangesRotting(int[][] grid) {        
        queue = new LinkedList<>();
        visited = new boolean[grid.length][grid[0].length];
        int countOne = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) countOne++;
                if (grid[i][j] == 2) {
                    visited[i][j] = true;
                    queue.add(new Pair(i, j, 0));
                }
            }
        }
        
        if (countOne == 0) return 0;
        
        bfs(grid);
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }        
        return count;
    }
    
    public void bfs(int[][] grid) {       
       while (!queue.isEmpty()) {
           Pair pair = queue.remove();
           
           count = pair.minute;
                     
           for (int k = 0; k < 4; k++) {
               int neighbourX = pair.i + dx[k];
               int neighbourY = pair.j + dy[k];
               
               if (neighbourX >= 0 && neighbourX < grid.length &&
                   neighbourY >= 0 && neighbourY < grid[0].length && 
                   grid[neighbourX][neighbourY] == 1 && !visited[neighbourX][neighbourY]) {
                   visited[neighbourX][neighbourY] = true;
                   queue.add(new Pair(neighbourX, neighbourY, count + 1));
               }
           }
       }
    }
    
    class Pair {
        int i;
        int j;
        int minute;
        
        public Pair(int i, int j, int minute) {
            this.i = i;
            this.j = j;
            this.minute = minute;
        }
    }
}
