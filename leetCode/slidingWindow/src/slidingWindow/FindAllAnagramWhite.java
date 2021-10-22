package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramWhite {

	public static void main(String[] args) {
		FindAllAnagramWhite anagrams = new FindAllAnagramWhite();
		anagrams.slidingWindowTemplate("aaabc", "aab");
	}
	
	public List<Integer> slidingWindowTemplate(String s, String t) {
		List<Integer> result = new ArrayList<>();
		int count_t [] = new int[26];
		
		for (int i = 0; i < t.length(); i++) {
			count_t[t.charAt(i) - 'a']++;
		}
		
		int left = 0;
		int right = 0;
		int count = t.length();
		
		while (right < s.length()) {
			if (count_t[s.charAt(right++) - 'a'] > 0) {
				count_t[s.charAt(right) - 'a']--;
				count--;
			}
			if (count == 0) result.add(left);
			if (right - left == t.length() && count_t[s.charAt(left++) - 'a'] > 0) {
				count_t[s.charAt(left) - 'a']++;
				count++;
			}
		}
		return result;
	}
}
