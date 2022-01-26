package array.sorting;

import java.util.Arrays;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 *
 */
public class SortByBits {

	public static void main(String[] args) {
		SortByBits sortByBits = new SortByBits();
		sortByBits.sortByBits(new int [] {0, 1, 3, 4, 5, 2});
	}

	public int[] sortByBits(int[] arr) {
        int curr [][] = new int[arr.length][2];
        
        for (int i = 0; i < arr.length; i++) {
            curr[i][0] = arr[i];
            curr[i][1] = Integer.bitCount(arr[i]);
        }
        
        Arrays.sort(curr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = curr[i][0];
        }
        
        return arr;
    }	
}
