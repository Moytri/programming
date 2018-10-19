Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false

My Solution:
class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        
        if(s.length() == 1) return false;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')') {
                if(stack.empty() || stack.peek() != '(') return false;
                if(!stack.empty()) stack.pop();
            }
            if(s.charAt(i) == '}') {
                if(stack.empty() || stack.peek() != '{') return false;
                if(!stack.empty()) stack.pop();
            }
            if(s.charAt(i) == ']') {
                if(stack.empty() || stack.peek() != '[') return false;
                if(!stack.empty()) stack.pop();
            }
        }
        if(!stack.empty()) return false;
        return true;
    }
}