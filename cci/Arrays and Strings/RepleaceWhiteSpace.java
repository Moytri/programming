/**
 * 1.3: URLify
 * Write a method to replace all spaces in a string with '%20'. You may assume
 * that the string has sufficient space at the end to hold the additional
 * characters, and that you are given the "true" length of the string.
 *
 * EXAMPLE
 * Input:   "Mr John Smith", 13
 * Output:  "Mr%20John%20Smith"
 */
package cciArrayString;

public class RepleaceWhiteSpace {

	public static void main(String[] args) {
		System.out.println(URLify("My name is Moytri"));
	}
	
	public static String URLify(String str) {
		StringBuilder sb = new StringBuilder();		
		for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch == ' ' ? "%20" : ch);
		}
		return sb.toString();
	}
}
