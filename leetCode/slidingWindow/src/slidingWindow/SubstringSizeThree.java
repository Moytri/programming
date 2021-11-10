package slidingWindow;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 *
 */
public class SubstringSizeThree {

	public static void main(String[] args) {
		SubstringSizeThree goodSubstring = new SubstringSizeThree();
		System.out.println(goodSubstring.countGoodSubstrings("xyzzaz"));
	}
	
	public int countGoodSubstrings(String s) {
        int count = 0;
        int i = 0, j = 0;
        
        while (j < s.length()) {
            if ((j == 0 && s.charAt(i) == s.charAt(j)) || s.charAt(i) != s.charAt(j) 
                && s.charAt(j) != s.charAt(j - 1)) {
                if (j - i == 2) {
                	count++;
                	i++;
                }
            }
            else if (s.charAt(j) == s.charAt(j - 1)) {
            	i = j;
            }
            else {
                i++;
            }
            j++;
        }
        return count;
    }

}
