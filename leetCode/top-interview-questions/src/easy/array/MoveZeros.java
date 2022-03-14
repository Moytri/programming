package easy.array;
/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
 *
 */
public class MoveZeros {

	public static void main(String[] args) {
		MoveZeros zeros = new MoveZeros();
		int nums [] = new int[] {1,0,5,8,0,12};
		zeros.moveZeroes(nums);
		zeros.print(nums);
	}
	
	public void moveZeroes(int[] nums) {
		int index = 0;
		int length = nums.length;
		
		for (int i = 0; i < length; i++) {
			if (nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[index];
				nums[index] = temp;
				index++;
			}
		}
	}
	
	public void print(int [] nums) {
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}

}
