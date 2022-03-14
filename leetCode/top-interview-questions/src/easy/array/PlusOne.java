package easy.array;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 * Similar questions: https://leetcode.com/problems/plus-one/solution/
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		PlusOne plusOne = new PlusOne();
		plusOne.plusOne(new int[] {1,3,4});
	}
	
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        
        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }	
}
