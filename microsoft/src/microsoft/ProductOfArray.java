package microsoft;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/product-of-array-except-self/
 */
public class ProductOfArray {

	public static void main(String[] args) {
		ProductOfArray productExceptSelf = new ProductOfArray();
		int [] nums = new int[] {1, 2, 3, 4};		
		int [] newArr = productExceptSelf.productExceptSelf(nums);
		
		for (Integer i : newArr) {
			System.out.print(i + " ");
		}
	}
	
	public int[] productExceptSelf(int[] nums) {
		int [] newArr = new int[nums.length];
		int product = 1;
		int length = nums.length;
		
		for (int i = 0; i < length; i++) {
			newArr[i] = product;
			product *= nums[i];
		}
		
		product = 1;
		for (int i = length - 1; i >=0; i--) {
			newArr[i] = newArr[i] * product;
			product = product * nums[i];
		}
		
		return newArr;
	}

}
