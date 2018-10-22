/**
 * 1.2: Check Permutation
 * Given two strings, write a method to decide if one is a permutation of the
 * other.
 */

package cciArrayString;

import java.util.Arrays;

public class CheckPermutation {

	public static void main(String[] args) {
		System.out.println(permutation("cat", "tca"));
	}
	
	//using sort and compare
	public static boolean permutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		return sort(str1).equals(sort(str2));
	}
	
	private static String sort(String str) {
		char ch [] = str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}

	//optimal solution using histogram approach - character count
	public static boolean checkPermutation(String str1, String str2) {
		if(str1.length() != str2.length()) return false;
		
		int [] count = new int[128];
		for(char ch : str1.toCharArray()) {
			count[ch]++;
		}
		
		for(int i = 0; i < str2.length(); i++) {
			char myChar = str2.charAt(i);
			count[myChar]--;
			if(count[myChar] < 0) return false;
		}
		return true;
	}
}
