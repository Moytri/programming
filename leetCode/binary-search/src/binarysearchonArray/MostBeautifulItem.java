package binarysearchonArray;

import java.util.Arrays;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/most-beautiful-item-for-each-query/
 *
 */
public class MostBeautifulItem {

	public static void main(String[] args) {
		MostBeautifulItem item = new MostBeautifulItem();
		item.maximumBeauty(new int [][] {{1,2}, {3,2}, {2,4}, {5,6}, {3,5}}, 
						   new int [] {1,2,3,4,5,6});
	}
	
	public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        
        for (int i = 1; i < items.length; i++) {
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);
        }
        
        int [] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            result[i] = binarySearch(items, queries[i]);
        }
        
        return result;
    }
    
    public int binarySearch(int [][] items, int target) {
        int start = 0; int end = items.length - 1; 
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            
            if (items[mid][0] <= target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        start = start != 0 ? start - 1 : 0;
        return items[start][0] <= target ? items[start][1] : 0;
    }

}
