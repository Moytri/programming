package recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations combination = new LetterCombinations();
		combination.letterCombinations("234");
	}
	
	 public List<String> letterCombinations(String digits) {
        String [] stringAgainstNumber = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combination = new ArrayList<>();
        String output = "";
        letterCombinations(digits, stringAgainstNumber, output, combination);
        return combination;
	  }
	    
	   
	private void letterCombinations(String digits, String [] stringAgainstNumber, String output, List<String> ls) {
    	if( digits.equals( "" ) ) {
            if( !output.equals( "" )) {
                ls.add( output );
            }
    		
    		return;
    	}
    	
    	char firstLetter = digits.charAt(0);
        String firstString = stringAgainstNumber[Character.getNumericValue(firstLetter)];
        String remainingDigits =  digits.substring(1);
        for(int i = 0; i < firstString.length(); i++) {
            letterCombinations( remainingDigits, stringAgainstNumber, output + firstString.charAt( i ), ls);
        }
    }

}
