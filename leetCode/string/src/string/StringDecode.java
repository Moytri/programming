package string;

import java.util.Stack;
/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/decode-string/solution/
 * To Do: use recursion
 *
 */
public class StringDecode {

	public static void main(String[] args) {
		StringDecode stringDecode = new StringDecode();
		System.out.println(stringDecode.decodeString("3[a2[bc]]"));
	}
	
	public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resultStack = new Stack<>();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                int num = 0;
                while (Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');
                    ch = s.charAt(++i);
                }
                countStack.push(num);
                i--;
            }
            else if (ch == '[') {
                resultStack.push(result);
                result = "";
            }
            else if (ch == ']') {
                StringBuilder sb = new StringBuilder(resultStack.pop());
                
                int repeateCount = countStack.pop();
                for (int j = 0; j < repeateCount; j++) {
                    sb.append(result); 
                }
                result = sb.toString();
            }
           else {
               result += ch;  
            }
        }
        return result;
    }
}
