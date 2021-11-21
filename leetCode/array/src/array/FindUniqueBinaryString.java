package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/find-unique-binary-string/
 *
 */
public class FindUniqueBinaryString {

	public static void main(String[] args) {
		FindUniqueBinaryString uniqueString = new FindUniqueBinaryString();
		uniqueString.findDifferentBinaryString(new String[] {"00","10"});
	}
	
	public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>();
        int length = nums.length;
        
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        
        for (int i = 0; i < Math.pow(2, length); i++) {
            String number = decimalToBinary(length, i);
            
            if (!set.contains(number)) return number;
        }
        
        return null;
    }
    
    private static String decimalToBinary(int width, int number) {
        String decimal = "";
        
        while (number != 0) {
            decimal = number%2 + decimal;
            number = number / 2;  
        }

        int diff = width - decimal.length();
        
        for (int i = 0; i < diff; i++) {
            decimal = "0" + decimal;
        }
        
        return decimal;
     }

}
