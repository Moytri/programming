package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
		public  static void main(String [] args) {
			MinimumWindowSubstring window = new MinimumWindowSubstring();
			System.out.println(window.minWindow("aa", "aa"));
		}
		
		public String minWindow(String s, String t) {
	        Map<Character, Integer> map = new HashMap<>();
	        
	        for (int i = 0; i < t.length(); i++) {
	            if (map.containsKey(t.charAt(i))) {
	                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
	            }
	            else {
	            	map.put(t.charAt(i), 1);
	            }	            
	        }
	        
	        int left = 0; int right = 0; int count = t.length();
	        int minLength = Integer.MAX_VALUE; int minStart = 0;
	        
	        while(right < s.length()) {
	            
	            if (map.containsKey(s.charAt(right))) {
	               if (map.get(s.charAt(right)) > 0) {
	                    count--;
	               }
	                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
	            }

	            
	            while (count == 0) {
	                if ((right - left + 1) < minLength) {
	                    minLength = right - left + 1;
	                    minStart = left;
	                }
	                if (map.containsKey(s.charAt(left))) {
	                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
	                   if (map.get(s.charAt(left)) > 0) {
	                        count++;
	                   }
	                }
	                left++;
	            }
	            
	            right++;
	        }
	        
	        if( minStart + minLength > s.length())
	            return "";
	        return s.substring(minStart, minStart + minLength);        
	    }
		
//		public String minWindow(String s, String t) {
//		    char[] s_array = s.toCharArray();
//		    char[] t_array = t.toCharArray();
//		    int[] map = new int[256];
//		    int end = 0;
//		    int start = 0;
//		    int min_length = Integer.MAX_VALUE;
//		    for(int i = 0; i < t_array.length; i++)
//		        map[t_array[i]] ++;
//		    int count = t_array.length;
//		    int min_start = 0;
//		    while(end < s_array.length)
//		    {
//		        if(map[s_array[end]] > 0)
//		        {
//		            count--;
//		        }
//		        map[s_array[end]] --;
//		        while(count == 0)
//		        {
//		            if((end - start + 1) < min_length)
//		            {
//		                min_length = end - start + 1;
//		                min_start = start;
//		            }
//		            map[s_array[start]] ++;
//		            if(map[s_array[start]] > 0){
//		                count ++;
//		            }
//		            start++;
//		        }
//		        end ++;
//		
//		    }
//		    if( min_start+min_length > s_array.length)
//		        return "";
//		    return s.substring(min_start, min_start+min_length);
//		}
}
