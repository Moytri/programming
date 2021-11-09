package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/multiply-strings/
 *
 */
public class MultiplyString {
	String output = "";
	
	public static void main(String[] args) {
		MultiplyString multiply = new MultiplyString();
		System.out.println(multiply.multiply("0", "0"));
	}
   
    public String multiply(String num1, String num2) {
        int product = 1; int carry = 0;
        int length1 = num1.length();
        int length2 = num2.length();
        List<Integer> ls;
        int [] sum = new int[length1 + length2 + 1];
        int [] carryOfSum = new int[length1 + length2 + 1];
        
        for (int i = length2 - 1; i >= 0; i--) {
            ls = new ArrayList<>();
            int index = length2 - 1 - i;
            for (int j = length1 - 1; j >= 0; j--) {
                product = (num2.charAt(i) - '0')
                           * (num1.charAt(j) - '0') + carry;
                           
                carry = product/10;              
                ls.add(product%10);
            }
            sumOfProducts(ls, index, sum, carryOfSum);
        }
        
        return myToString(sum);                           
    }
    
    private void sumOfProducts(List<Integer> ls, int index, int[] sum, int[] carryOfSum) {
    	int k = index;
        for (int i = 0; i < ls.size(); i++) {
            int result = sum[index] + ls.get(i) + carryOfSum[i];
            if (i + 1 < carryOfSum.length) {
                carryOfSum[i + 1] = result/10;
            }
            sum[i + k] = result%10;
            index++;
        }
    }
    
    public String myToString(int [] sum) {
        for (int i = sum.length - 1; i >= 0; i--) {
            output = output + sum[i];
        }
        for (int i = 0; i < output.length(); i++) {
            if (output.charAt(i) != '0'){
                return output.substring(i, output.length());
            }
        }
        return output;
    }

}
