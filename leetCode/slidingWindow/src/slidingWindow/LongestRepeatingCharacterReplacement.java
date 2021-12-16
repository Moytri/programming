package slidingWindow;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 */
public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement repeatingCharacter = new LongestRepeatingCharacterReplacement();
		System.out.println(repeatingCharacter.characterReplacement("AABABBA", 1));
	}
	
	public int characterReplacement(String s, int k) {
        int[] cArr = new int[26];
        int maxCount = 0, start = 0, maxSize = 0;
        
        for(int end = 0; end < s.length(); end ++){
            cArr[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, cArr[s.charAt(end) - 'A']);
            
            // if max character frequency + distance between start and end is greater than k
            // this means we have considered changing more than k charactres. So time to shrink window
            if(end - start + 1 - maxCount > k){
                cArr[s.charAt(start) - 'A']--;
                start ++;
            }
            
            maxSize = Math.max(maxSize, end - start + 1);
        }
        
        return maxSize;
    }

}
