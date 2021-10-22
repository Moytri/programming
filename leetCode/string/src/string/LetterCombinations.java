package string;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations combinations = new LetterCombinations();
		combinations.letterCombinations("23");
	}
    public List<String> letterCombinations(String digits) {
        String [] numbers = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ls = new ArrayList<>();
        String current = "";
        letterCombinations(digits, numbers, current, ls);
        return ls;
    }
    
    private void letterCombinations(String digits, String[] numbers, String current, List<String> ls) {
    	if (digits.equals("")) {
    		if (current.equals("")) {
	    		ls.add(current);
	    		return;
    		}
    	}
    	
    	String letters = numbers[digits.charAt(0) - '0'];
    	String rest =  digits.substring(1);
    	
    	for (int i = 0; i < letters.length(); i++) {
    		letterCombinations(rest, numbers, current + letters.charAt(i), ls);
    	}
    }

}
