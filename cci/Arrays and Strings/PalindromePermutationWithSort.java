package cciArrayString;

import java.util.Arrays;

public class PalindromePermutationWithSort {

	public static void main(String[] args) {
		PalindromePermutationWithSort palindrom = new PalindromePermutationWithSort();
		String [] cases = {"aabab", "a"};
		for( String s : cases ) {
			System.out.println(s + " : " + palindrom.PalindromePermutaion(s));		
		}
	}
	
	public boolean PalindromePermutaion(String str) {
		char[] chArr = str.toCharArray();
		Arrays.sort(chArr);
		
		int oddCount = 0;
		int frequency = 1;
		
		for(int i = 0; i <= chArr.length - 2; i++) {	
			if(chArr[i] == chArr[i + 1]) {
				++frequency;
			}
			else {
				if(frequency % 2 == 1) {
					oddCount++;
				}
				if(oddCount > 1) return false;
				frequency = 1;
			}
		}
		
		//for the last single index
		if(frequency % 2 == 1) {
			oddCount++;
		}
		if(oddCount > 1) return false;
		
		return true;
	}

}
