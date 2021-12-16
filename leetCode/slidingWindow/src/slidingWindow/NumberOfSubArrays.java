package slidingWindow;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/count-number-of-nice-subarrays/
 *
 */
public class NumberOfSubArrays {

	public static void main(String[] args) {
		NumberOfSubArrays numberOfSubArrays = new NumberOfSubArrays();
		//System.out.println(numberOfSubArrays.numberOfSubarrays(new int[] {1,1,2,1,2,1}, 3));
		System.out.println(numberOfSubArrays.numberOfSubarrays(new int[] {2,2,2,1,2,2,1,2,2,2}, 2));
	}
	
	public int numberOfSubarrays(int[] nums, int k) {
        int res = 0, i = 0, count = 0, n = nums.length;
        for (int j = 0; j < n; j++) {
            if (nums[j] % 2 == 1) {
                --k;
                count = 0;
            }
            while (k == 0) {
                if (nums[i++] % 2 == 1) ++k;
                ++count;
            }
            res += count;
        }
        return res;
    }

}
