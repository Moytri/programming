package microsoft;

public class BestTimeToBuyAndSell {

	public static void main(String[] args) {
		BestTimeToBuyAndSell bestTime = new BestTimeToBuyAndSell();
		System.out.println(bestTime.maxProfit(new int[] {7,2,1,4,8}));
	}
	
	public int maxProfit(int[] prices) {
        int length = prices.length;
        int min = prices[0];
        int maxProfit = length > 1 ? prices[1] - prices[0] : 0;
        
        for (int i = 0; i < prices.length; i++) {
             min = Math.min(prices[i], min);
            
             int profit = prices[i] - min;
             maxProfit = Math.max(maxProfit, profit);
        }
        
        return maxProfit;
    }

}
