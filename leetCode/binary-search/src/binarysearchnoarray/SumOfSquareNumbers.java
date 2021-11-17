package binarysearchnoarray;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/sum-of-square-numbers/
 *
 */
public class SumOfSquareNumbers {

	public static void main(String[] args) {
		SumOfSquareNumbers sumOfSquareNumber = new SumOfSquareNumbers();
		System.out.println(sumOfSquareNumber.judgeSquareSum(5));
	}
	
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = (int) (c - (a * a));
            if (binary_search(0, b, b)) return true;
        }
        
        return false;
    }
    
    private boolean binary_search(long start, long end, int n) {
        if (start > end) return false;
        long mid = start + (end - start)/2;

        if (mid * mid == n) return true;      
        if (mid * mid > n) return binary_search(start, mid - 1, n);
        
        return binary_search(mid + 1, end, n);
    }	

}
