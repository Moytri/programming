package dp;

import java.util.Arrays;

public class MinimumFailingPath {
	int [][] dp; int row; int col;
	public static void main(String[] args) {
		MinimumFailingPath failingPath = new MinimumFailingPath();
		System.out.println(failingPath.minFallingPathSum(
					new int[][] {
						{2,1,3},
						{6,5,4},
						{7,8,9}
					}
				));
	}
	
    public int minFallingPathSum(int[][] matrix) {
        this.row = matrix.length - 1;
        this.col = matrix[0].length - 1;
        this.dp = new int[row + 1][col + 1];
        
        for (int[] row: dp)
            Arrays.fill(row, -101);
        
        int min = Integer.MAX_VALUE;        
        for (int k = 0; k <= col; k++) {
            min = Math.min(dp(0, k, matrix), min);
        }
        
        return min;
    }
    
    private int dp(int i, int j, int [][] matrix) {        
        if (isLimit(i, j)) return Integer.MAX_VALUE;
        
        if (i == row) return matrix[i][j];
            
        if (dp[i][j] == -101) {
            dp[i][j] = Math.min(
                                Math.min(dp(i + 1, j - 1, matrix),
                                         dp(i + 1, j, matrix)),
                                dp(i + 1, j + 1, matrix)) 
                       + matrix[i][j];
        }
        
        return dp[i][j];
    }
    
    private boolean isLimit(int i, int j) {
        return i < 0 || i > row || j > col || j < 0;
    }
}
