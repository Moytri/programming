package cciArrayString;

/*Palindrome Permutation: Given a string, write a function to check if it is a permutation of
a palindrome. A palindrome is a word or phrase that is the same forwards and backwards. A
permutation is a rearrangement of letters. The palindrome does not need to be limited to just
dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat'; "atc o eta·; etc.)*/

public class PalindromePemutation {

	public static void main(String[] args) {
		PalindromePemutation palindrom = new PalindromePemutation();
		String [] cases = {"a", "a a", "ab" , "ab ab"};
		for( String s : cases ) {
			System.out.println(s + " : " + palindrom.palindromePermutation(s));		
		}
	}
	
	public boolean palindromePermutation(String str) {
		if(str == null || str.isEmpty()) return false;
		if(str.length() == 1) return true;
		int [] count = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') continue;
			count[str.charAt(i) - 'a']++;
		}
		
		int oddCount = 0;
		
		for(int i = 0; i < count.length; i++) {
			if(count[i] % 2 == 1) oddCount++;
			if(oddCount > 1) return false;
		}
		
		return true;
	}

}
