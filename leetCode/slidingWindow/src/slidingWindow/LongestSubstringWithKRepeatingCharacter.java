package slidingWindow;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * Tutorial: https://www.youtube.com/watch?v=bHZkCAcj3dc
 *
 */
public class LongestSubstringWithKRepeatingCharacter {

	public static void main(String[] args) {
		LongestSubstringWithKRepeatingCharacter longestRepeatingChar = new LongestSubstringWithKRepeatingCharacter();
		System.out.println(longestRepeatingChar.longestSubstring("aaabb", 3));
		System.out.println(longestRepeatingChar.longestSubstring("ababacb", 3));
	}
	
	public int longestSubstring(String s, int k) {
	    int length = s.length();
	    
	    if (length == 0 || length < k) return 0;        
	    if (k == 1) return length;
	    
	    int [] count = new int[26];
	    
	    for (int i = 0; i < length; i++) {
	        count[s.charAt(i) - 'a']++;
	    }
	    
	    int i = 0;
	    
	    while (i < length && count[s.charAt(i) - 'a'] >= k) i++;
	    if (i >= length - 1) return i;
	    
	    int length_1 = longestSubstring(s.substring(0, i), k);
	    
	    while (i < length && count[s.charAt(i) - 'a'] < k) i++;
	    
	    int length_2 = i < length ? longestSubstring(s.substring(i), k) : 0;
	    
	    return Math.max(length_1, length_2);
        
	}	

}
