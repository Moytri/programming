package binarysearchonArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/k-diff-pairs-in-an-array/
 *
 */
public class KDiffPair {

	public static void main(String[] args) {
		KDiffPair kPairs = new KDiffPair();
		System.out.println(kPairs.findPairs(new int[] {3,1,4,1,5}, 2));
		System.out.println(kPairs.findPairs(new int[] {1,2,3,4,5}, 1));
		System.out.println(kPairs.findPairs(new int[] {1,3,1,5,4}, 0));
		
		System.out.println(kPairs.findTotalPairs(new int[] {3,1,4,1,5}, 2));
		System.out.println(kPairs.findTotalPairs(new int[] {1,2,3,4,5}, 1));
		System.out.println(kPairs.findTotalPairs(new int[] {1,3,1,5,4}, 0));
	}
	
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 2) return 0;
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (hasPair(nums, i + 1, nums[i] + k)) count++;
        }
        return count;
    }
    
    public boolean hasPair(int [] nums, int start, int target) {
       int end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
    
    /******************************************************
    			WE CAN SOLVE IT USING HASHMAP
    ******************************************************/
    
    public int findTotalPairs(int [] nums, int k) {
    	int count = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for (int i = 0; i < nums.length; i++) {
    		map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);
    	}
    	
    	for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
    		int key = entry.getKey();
    		int val = entry.getValue();
    		
    		if (k > 0 && map.containsKey(key + k)) count++;
    		else if (k == 0 && val > 1) count++;
    	}
    	return count;
    }

}
