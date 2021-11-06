package math;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 */
public class MaximumProductOfThreeNumbers {

	public static void main(String[] args) {
		MaximumProductOfThreeNumbers maximumProduct = new MaximumProductOfThreeNumbers();
		System.out.println(maximumProduct.maximumProduct(new int[] {-1, 0, 9, -6}));
	}
	
	public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE; int min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE; int max2 = Integer.MIN_VALUE; 
        int max3 = Integer.MIN_VALUE;
       
        for (int i = 0; i <nums.length; i++) {
            int num = nums[i];

            if (num <= min1) {
                min2 = min1;
                min1 = num;
            }
            else if (num <= min2) {
                min2 = num;
            }
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (num >= max2) {
                max3 = max2;
                max2 = num;
            }
            else if (num >= max3) {
                max3 = num;
            }            
        }

        return Math.max(min1*min2*max1,max1*max2*max3);
    }	

}
