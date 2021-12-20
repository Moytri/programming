package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/pascals-triangle/
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		System.out.println(pascalTriangle.generate(5));
	}
	
	class Solution {
	    int[][] dp;
	    public List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> pascal = new ArrayList<>();
	        if (numRows <= 0){
	            return pascal;
	        }
	        
	        // two loops: first one is for row, second one is for column
	        // thoughts: 1st and last column will be always 1 for every row
	        //           matrix[row][col] = matrix[row - 1][col - 1] + matrix[row - 1][col]
	        // inner list represents row
	        for (int i = 0; i < numRows; i++) {
	            List<Integer> row = new ArrayList<>();
	            
	            for (int j = 0; j < i+1; j++) {
	                if (j == 0 || j == i) {
	                    row.add(1);
	                }
	                else {
	                    row.add(pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j));
	                }
	            }
	            pascal.add(row);
	        }
	        return pascal;
	    }
	}
	
}
