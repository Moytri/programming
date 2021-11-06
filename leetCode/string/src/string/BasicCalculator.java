package string;

import java.util.Stack;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/basic-calculator/
 *
 */
public class BasicCalculator {

	public static void main(String[] args) {
		BasicCalculator calculator = new BasicCalculator();
		calculator.calculate("(1+(4+5+2)-3)+(6+8)");
	}
	
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		int operator = 1; int result = 0; int currentNumber = 0;
	        
       for (int i = 0; i < s.length(); i++) {
           char currentChar = s.charAt(i);
           
           if (Character.isDigit(currentChar)) {
               currentNumber = currentNumber * 10 + (currentChar - '0');
           }
           if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == s.length() - 1) {
               if (operator == 1) {
                   result += currentNumber;
               }
               if (operator == -1) {
                   result -= currentNumber;
               }
               if (currentChar == '(') {
                   stack.push(result);
                   stack.push(operator);
                   result = 0;
                   operator = 1;
               }
               if (currentChar == ')') {
                   result = result * stack.pop() + stack.pop();
               }
               if (currentChar != ')' && currentChar != '(') operator = currentChar == '+' ? 1 : -1;
               currentNumber = 0;
           }
       }
	        
        return result;
    }	
}
