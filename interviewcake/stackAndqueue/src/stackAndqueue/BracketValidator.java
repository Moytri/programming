package stackAndqueue;

import java.util.Stack;

public class BracketValidator {
	
	public static boolean isValid(String code) {

        // determine if the input code is valid
        int length = code.length();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < length; i++) {
            if (code.charAt(i) == '(' || code.charAt(i) == '{' || code.charAt(i) == '[') {
                stack.push(code.charAt(i));
            }
            else if (code.charAt(i) == ')') {
                if (stack.isEmpty()) return false;
                
                char ch = stack.pop();
                if (ch != '(') return false;
            }
            else if (code.charAt(i) == '}') {
                if (stack.isEmpty()) return false;
                
                char ch = stack.pop();
                if (ch != '{') return false;
            }
            else if (code.charAt(i) == ']') {
                if (stack.isEmpty()) return false;
                
                char ch = stack.pop();
                if (ch != '[') return false;
            }
        }
        return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
