package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<String> letterCombinations(String digits) {
        String [] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ls = new ArrayList<>();
        String output = "";
        letterCombinations(digits, numbers, output, ls);
        return ls;
	  }
	    
	   
	private void letterCombinations(String digits, String [] numbers, String output, List<String> ls) {
    	if( digits.equals( "" ) ) {
            if( !output.equals( "" )) {
                ls.add( output );
            }
    		
    		return;
    	}
    	
    	char ch = digits.charAt(0);
        String myStr = numbers[Character.getNumericValue(ch)];
        String rest =  digits.substring(1);
        for(int i = 0; i < myStr.length(); i++) {
            letterCombinations( rest, numbers, output + myStr.charAt( i ), ls);
        }
    }

}
