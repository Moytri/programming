package array;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellII {

	public static void main(String[] args) {
		BestTimeToBuyAndSellII bestTime = new BestTimeToBuyAndSellII();
		System.out.println(bestTime.maxProfit(new int[] {7,1,5,3,6,4}));
	}
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

}
