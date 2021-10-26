package microsoft;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/number-of-islands/
 *
 */
public class NumberOfIslandsDFS {

	int startRow; int endRow; int startCol; int endCol;
	public static void main(String[] args) {
		NumberOfIslandsDFS numberOfIslands = new NumberOfIslandsDFS();
		
		char [][] grid = new char[][] {
			{'1','1','1','1','0'},
			{'1','1','0','1','0'},
			{'1','1','0','0','0'},
			{'0','0','0','0','0'}};
		
		numberOfIslands.startRow = 0; numberOfIslands.endRow = grid.length;
		numberOfIslands.startCol = 0; numberOfIslands.endCol = grid[0].length;
		
		int numOfIsland = numberOfIslands.numIslands(grid);	
		System.out.println(numOfIsland);
	}
	
	public int numIslands(char[][] grid) {
		int count = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfsChangeLandValue(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}
	
	private void dfsChangeLandValue(char[][] grid, int i, int j) {
		if (i < startRow || i > endRow || j < startCol || j > endCol || grid[i][j] != '1') return;
		
		grid[i][j] = '0';
		
		dfsChangeLandValue(grid, i - 1, j);
		dfsChangeLandValue(grid, i + 1, j);
		dfsChangeLandValue(grid, i, j - 1);
		dfsChangeLandValue(grid, i, j + 1);
	}

}
