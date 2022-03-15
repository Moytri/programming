package easy.string;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/880/
 *
 */
public class ReverseIntger {

	public static void main(String[] args) {
		ReverseIntger reverseInt = new ReverseIntger();
		System.out.println(reverseInt.reverse(123));
		System.out.println(reverseInt.reverse(-123));
	}
	
    public int reverse(int x) {
        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) return 0;
        
        boolean isNegative = false;
        if (x < 0) isNegative = true;
        
        x = Math.abs(x);
        long reversedValue = 0;
        
        while(x != 0) {
            reversedValue = reversedValue * 10 + x % 10;
            x /= 10;
        }
        
        if (reversedValue > Integer.MAX_VALUE || reversedValue < Integer.MIN_VALUE) return 0;
        
        return isNegative ? (int) (-1 * reversedValue) : (int) reversedValue;
    }	

}
