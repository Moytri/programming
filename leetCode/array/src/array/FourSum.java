package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/4sum/
 *
 */
public class FourSum {

	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
		List<List<Integer>> ls = fourSum.fourSum(new int[] {1,0,-1,0,-2,2}, 0);
		System.out.println(ls.size());
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> inner;
        
        int i = 0; int j = i + 1; int length = nums.length;
        
        int newNums [] = new int[nums.length];
        
        for (int k = 0; k < length; k++) {
            newNums[k] = nums[k];
        }
        
        Arrays.sort(newNums);
                
        while (j < length) {
            int sum = nums[i] + nums[j];
            int k = 0; int l = length - 1;
            
            while (k < l) {
                if (sum + newNums[k] + newNums[l] == target) {
                    inner = new ArrayList<>();
                    inner.add(nums[i]); inner.add(nums[j]); 
                    inner.add(newNums[k]); inner.add(newNums[l]);
                    
                    outer.add(inner);
                    break;
                }
                else if (sum + newNums[k] + newNums[l] > target) {
                    l--;
                }
                else {
                    k++;
                }
            }
            i++; j++;
        }
        return outer;
    }
}
