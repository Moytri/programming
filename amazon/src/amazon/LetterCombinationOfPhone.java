package amazon;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {

	public static void main(String[] args) {
		LetterCombinationOfPhone letterCombination = new LetterCombinationOfPhone();
		letterCombination.letterCombinations("23");
	}
	
	public List<String> letterCombinations(String digits) {
        String [] lettersOfDigits = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> combinations = new ArrayList<>();
        String current = "";
        letterCombinations(digits, lettersOfDigits, current, combinations);
        return combinations;
    }
	
	public void letterCombinations(String digits, String[] lettersOfDigits, String current, List<String> combinations) {
		if (!digits.equals("")) {
			if (!current.equals("")) {
				combinations.add(current);
			}
		}
		String lettersOfFirstDigit = lettersOfDigits[digits.charAt(0) - '0'];
		String remainingDigits = digits.substring(1);
		
		for (int i = 0; i < lettersOfFirstDigit.length(); i++) {
			letterCombinations(remainingDigits, lettersOfDigits, current, combinations);
		}
	}

}
