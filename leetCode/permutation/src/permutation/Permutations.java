package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/permutations/
 */
public class Permutations {

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		Permutations permutation = new Permutations();
		System.out.println(permutation.permute(nums).size());
	}
	
	private List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		getPermutedList(nums, permutations, 0, nums.length - 1);
		return permutations;
	}
	
	private void getPermutedList(int[] nums, List<List<Integer>> permutations, int start, int end) {
		if (start == end) {
			List<Integer> permutation = new ArrayList<>();
			
			for (int i = 0; i < nums.length; i++) {
				permutation.add(nums[i]);
			}
			permutations.add(permutation);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			nums = swap(nums, i, start);
			getPermutedList(nums, permutations, start + 1, end);
			nums = swap(nums, i, start);
		}
	}
	
	private int[] swap(int[] nums, int i, int start) {
		int temp = nums[i];
		nums[i] = nums[start];
		nums[start] = temp;
		return nums;
	}
	
}
