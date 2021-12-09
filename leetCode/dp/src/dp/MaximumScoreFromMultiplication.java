package dp;

import java.util.Arrays;

public class MaximumScoreFromMultiplication {

	public static void main(String[] args) {
		MaximumScoreFromMultiplication maximumScore = new MaximumScoreFromMultiplication();
		int [] nums = new int[] {1,2,3};
		int [] multipliers = new int[] {3,2,1};
		System.out.println(maximumScore.maximumScore(nums, multipliers));
	}

	int i = 0; int j; int p = 0; int n; int [][] dp;
    public int maximumScore(int[] nums, int[] multipliers) {
        this.j = multipliers.length;
        this.n = nums.length;
        dp = new int[j][j];
        
        for (int[] row: dp)
            Arrays.fill(row, 1001);
        
        return dp(nums, multipliers, i, p);
    }
    
    public int dp(int [] nums, int [] multipliers, int i, int p) {
        if (i == j) return 0;
        
        int q = n - 1 - i + p;
        if (dp[i][p] == 1001) {
            dp[i][p] = Math.max(
                            (nums[p] * multipliers[i]) + dp(nums, multipliers, i + 1, p + 1),
                            (nums[q] * multipliers[i]) + dp(nums, multipliers, i + 1, p)
                        );
        }
        
        return dp[i][p];
    }
}
