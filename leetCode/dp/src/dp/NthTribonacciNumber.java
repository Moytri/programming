package dp;

import java.util.Arrays;

public class NthTribonacciNumber {
    int [] dp;
	public static void main(String[] args) {
		NthTribonacciNumber nthTribonacci = new NthTribonacciNumber();
		System.out.println(nthTribonacci.tribonacci(35));
	}
	
    public int tribonacci(int n) {
        if(dp == null) {
            dp = new int[38];
            Arrays.fill(dp, -1);
        }
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        
        if (dp[n] == -1) {
            dp[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);            
        }
                
        return dp[n];
    }	
}
