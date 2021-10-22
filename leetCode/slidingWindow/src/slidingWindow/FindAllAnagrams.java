package slidingWindow;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {

	public static void main(String[] args) {
		FindAllAnagrams anagrams = new FindAllAnagrams();
		List<Integer> result = anagrams.findAnagrams("aaabcaa", "aab");
		for(Integer i : result) {
			System.out.println(i);
		}
	}
	
	public List<Integer> findAnagrams(String str, String p) {
		List<Integer> result = new ArrayList<>();
		int [] count_p = new int[26];
		
		for (int i = 0; i < p.length(); i++) {
			count_p[p.charAt(i) - 'a']++;
		}
		
		int windowStart = 0;
		int windowEnd = 0;
		
		while(windowEnd < str.length()) {
			if (count_p[str.charAt(windowEnd) - 'a'] > 0) {
				count_p[str.charAt(windowEnd) - 'a']--;
				windowEnd++;
				
				if (windowEnd - windowStart == p.length()) result.add(windowStart);
			}
			else if (windowStart == windowEnd) {
				windowStart++;
				windowEnd++;
			}
			else {
				count_p[str.charAt(windowStart++) - 'a']++;
			}
		}
		return result;
	}

}
