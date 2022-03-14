package medium.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/subsets/
 *
 */
public class SubSets {

	public static void main(String[] args) {
		SubSets subSets = new SubSets();
		subSets.subsets(new int [] {1, 2, 3});
	}
	
	public List<List<Integer>> subsets(int[] S) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
	    if(S.length == 0){
	        return result;
	    }
	    
	    Arrays.sort(S);
	    dfs(S, 0, new ArrayList<Integer>(), result);
	    return result;
	}
	
	public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
		result.add(new ArrayList<Integer>(path));
		
		for (int i = index; i < nums.length; i++) {
			System.out.println(":: " + i);
			path.add(nums[i]);
			dfs(nums, i + 1, path, result);
			path.remove(path.size() - 1);
		}
	}

}
