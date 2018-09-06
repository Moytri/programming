First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.

So I grabbed Apple's stock prices from yesterday and put them in an array called stockPrices, where:

The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
The values are the price (in US dollars) of one share of Apple stock at that time.
So if the stock cost $500 at 10:30am, that means stockPrices[60] = 500.

Write an efficient method that takes stockPrices and returns the best profit I could have made from one purchase and one sale of one share of Apple stock yesterday.

For example:

  int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};

getMaxProfit(stockPrices);
// returns 6 (buying for $5 and selling for $11)

No "shorting"—you need to buy before you can sell. Also, you can't buy and sell in the same time step—at least 1 minute has to pass.

https://www.interviewcake.com/question/java/stock-price

My Java Solution in O(n)
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int getMaxProfit(int[] stockPrices) {

        // calculate the max profit
        int max = 0;
        int max_index = 0;
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        
        for(int i = 0; i < stockPrices.length; i++) {
            if(stockPrices[i] > max) {
                max = stockPrices[i];
                max_index = i;
            }
            if(stockPrices[i] < min) {
                min = stockPrices[i];
                min_index = i;
            }
        }

        if(max_index == 0) {
            return stockPrices[max_index + 1] - max;
        }
        if(max_index < min_index) {
            return min - max;
        }
        return max - min;
    }





    // tests

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[] {1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[] {7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[] {9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[] {1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[] {5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[] {});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}