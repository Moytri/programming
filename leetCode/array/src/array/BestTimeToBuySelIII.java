package array;

public class BestTimeToBuySelIII {
	int count = 2;
	public static void main(String[] args) {
		BestTimeToBuySelIII profit = new BestTimeToBuySelIII();
		profit.maxProfit(new int[] {3,3,5,0,0,3,1,4});
	}
		
    public int maxProfit(int[] prices) {
        int totalMaxProfit = 0;
        maxProfit(prices, 0, totalMaxProfit);
        return totalMaxProfit;
    }
    
    private void maxProfit(int[] prices, int index, int totalMaxProfit) {
        int length = prices.length;
        int minPrice = prices[index];
        int maxProfit = length > 1 ? prices[index + 1] - prices[index] : 0;
        
        while (index < length) {
            minPrice = Math.min(minPrice, prices[index]);
            int profit = prices[index] - minPrice;
            
            if (profit > maxProfit) {
                if (count == 0) return;
                maxProfit = profit;
                totalMaxProfit += maxProfit;
                count--;
                maxProfit(prices, index + 1, totalMaxProfit);
            }
            index++;
        }
    }	

}
