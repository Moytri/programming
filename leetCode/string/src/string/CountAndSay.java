package string;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/count-and-say/
 *
 */
public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay countAndSay = new CountAndSay();
		System.out.println(countAndSay.countAndSay(5));
	}
	
	 public String countAndSay(int n) {
	        if (n < 1) return "";
	        String result = "1";
	        
	        if (n == 1) return result;
	        
	        for (int i = 2; i <= n; i++) {
	            int count = 0;
	            StringBuilder sb = new StringBuilder();
	            
	            for (int j = 0; j < result.length(); j++) {
	                char ch = result.charAt(j);
	                count++;
	                
	                while (j + 1 < result.length() && ch == result.charAt(j + 1)) {
	                    count++;
	                    j++;
	                }
	                
	                sb.append(count).append(ch);
	                count = 0;
	            }
	            result = sb.toString();
	        }
	        
	        return result;
	    }
}
