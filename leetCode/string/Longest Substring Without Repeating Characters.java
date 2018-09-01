Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", which the length is 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

Java Solution:
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer>  map = new HashMap<>();
        int i = 0;
        int count = 0;
        
        for(int j = 0; j < s.length(); j++) {
            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                count++;
                
                if(max < count) {
                    max = count;
                }
            }
            else {
            	if(i < s.length()) {
            		j = i;
            	}
                i++;
                count = 0;
                map.clear();
            }
        }
        return max;
    }
}