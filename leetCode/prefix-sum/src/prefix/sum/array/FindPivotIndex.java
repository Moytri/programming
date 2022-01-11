package prefix.sum.array;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/find-pivot-index/
 *
 */
public class FindPivotIndex {

	public static void main(String[] args) {
		FindPivotIndex findPivot = new FindPivotIndex();
		System.out.println(findPivot.findPivotIndex(new int [] {2,3,-1,8,4}));
	}
	
	public int findPivotIndex(int[] nums) {
        int [] leftSum = new int[nums.length];
        int [] rightSum = new int[nums.length];
        
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            leftSum[i] = sum;
            sum = sum + nums[i];
        }
        
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSum[i] = sum;
            sum = sum + nums[i];            
        }
        
        for (int i = 0; i < leftSum.length; i++) {
            if (leftSum[i] == rightSum[i]) return i;
        }
        
        return -1;
    }	

}
