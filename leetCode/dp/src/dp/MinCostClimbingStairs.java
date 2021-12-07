package dp;

import java.util.HashMap;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 */
public class MinCostClimbingStairs {
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int[] cost;
    
	public static void main(String[] args) {
		MinCostClimbingStairs minimumCost = new MinCostClimbingStairs();
		System.out.println(minimumCost.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
	}
	    
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        return dp(cost.length);
    }
    
    public int dp(int i) {
        if (i <= 1) return 0;
        
        if (!memo.containsKey(i)) {
            memo.put(i, Math.min((dp(i - 1) + cost[i - 1]), 
                                 dp(i - 2) + cost[i - 2]));
        }
        return memo.get(i);
    }	

}
