Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

https://leetcode.com/problems/two-sum/description/

My Solution in Java:
class Solution {

   //Approach One:
    public int[] twoSum(int[] nums, int target) {
        int [] arr = new int[2];
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j <= nums.length - 1; j++) {
                if(nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
    
	//Approach Two:
    public int[] twoSum(int[] nums, int target) {
	        int [] arr = new int[2];
	        Map<Integer, Integer> map = new HashMap<>();
	        
	        for(int i = 0; i < nums.length; i++) {
	        	if(map.containsKey(target - nums[i])) {
	        		arr[1] = i;
	        		arr[0] = map.get(target - nums[i]);
	        		return arr;
	        	}
	        	map.put(nums[i], i);
	        }
	        return arr;
	  }
}