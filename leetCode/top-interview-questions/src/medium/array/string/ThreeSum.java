package medium.array.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 *
 */
public class ThreeSum {

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		System.out.println(threeSum.threeSum(new int [] {-1,0,1,2,-1,-4}));
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int j = i + 1; int k = nums.length - 1;
                
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (k > j && nums[k - 1] == nums[k]) k--;
                        j++; k--;
                    }
                    else if (nums[i] + nums[j] + nums[k] > 0) k--;
                    else j++;
                }
            }
        }
        return result;
    }
}
