package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class LongestSubstringWithoutRepeatingCharacter {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacter substring = new LongestSubstringWithoutRepeatingCharacter();
		System.out.println(substring.lengthOfLongestSubstring("abba"));
	}
	
	public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s == null) return 0;

        Map<Character, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int longestLength = Integer.MIN_VALUE;
        
        // store every character and its position into a map
        // If the character is already in the map, we have to exclude it from the substring
        // To exclude the repeated character from the substring, we will shift the 'left' pointer
        // new position of 'left' will always greater than or equal to current position
        // we will find the index of the repeated character and increment it by 1 and set it a 'left', but
        // make sure the new value is not less than current 'left'
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                int index = map.get(s.charAt(right)); 
                left = Math.max(left,index + 1);
                map.remove(s.charAt(right));                
            }
            map.put(s.charAt(right), right);
            longestLength = Math.max(longestLength, (right - left) + 1);
            right++;
        }
        
        return longestLength;
    }	

}
