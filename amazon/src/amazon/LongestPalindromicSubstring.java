package amazon;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		LongestPalindromicSubstring longestPalindromicSubString = new LongestPalindromicSubstring();
		System.out.println(longestPalindromicSubString.longestPalindrome("cbbd"));
	}
	
	public String longestPalindrome(String s) {
        int length = s.length();
        int i = 0; int j = 0;
        int max = Integer.MIN_VALUE;
        int longestStart = 0;
        int longestEnd = 0;
        
        while (j < length) {
            if (isPalindrom(s, i, j)) {
                if (j - i + 1 > max) {
                    max = j - i + 1;
                    longestStart = i;
                    longestEnd = j;
                    j++;
                }
                else {
                    i++;
                    j = i;
                }
            }
            else {
            	j++;
            }
        }
        
        return s.substring(longestStart, longestEnd + 1);
    }
    
    public boolean isPalindrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}
