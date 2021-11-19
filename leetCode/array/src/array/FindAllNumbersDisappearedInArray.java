package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 */
public class FindAllNumbersDisappearedInArray {

	public static void main(String[] args) {
		FindAllNumbersDisappearedInArray allNumbers = new FindAllNumbersDisappearedInArray();
		allNumbers.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
	}
	
	public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] counts = new int[nums.length + 1];
        List<Integer> ls = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]]++;
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (i != 0 && counts[i] == 0) ls.add(i);
        }
        return ls;
    }
}
