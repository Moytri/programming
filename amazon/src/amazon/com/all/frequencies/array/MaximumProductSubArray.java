package amazon.com.all.frequencies.array;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/maximum-product-subarray/
 * Learned from: https://leetcode.com/problems/maximum-product-subarray/discuss/1608862/JAVA-or-3-Solutions-or-Detailed-Explanation-Using-Image
 *
 */
public class MaximumProductSubArray {

	public static void main(String[] args) {
		MaximumProductSubArray maximumSubArr = new MaximumProductSubArray();
		System.out.println(maximumSubArr.maxProduct(new int[] {2,3,-2,4}));

	}
	
	 public int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int leftProduct = 1; int rightProduct = 1;
        int length = nums.length;
        
        for (int i = 0; i < length; i++) {
            
            leftProduct =  leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;
            
            leftProduct *= nums[i];
            rightProduct *= nums[length - 1 - i];
            
            maxProduct = Math.max(Math.max(leftProduct, rightProduct),maxProduct);
        }
        
        return maxProduct;
	  }	
}
