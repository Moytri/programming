//Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

package cciArrayString;

import java.util.HashSet;
import java.util.Set;

/*
 * Link of Optimal Solution in Java
 * https://stackoverflow.com/questions/19484406/detecting-if-a-string-has-unique-characters-comparing-my-solution-to-cracking
*  MY SOLUTION takes O(n^2) time 
*/
public class IsUnique {

	public static void main(String [] args) {
		String str = "MyNae";
		System.out.println(new IsUnique().isUnique(str));
	}
	
	//without using additional space
	private boolean isUnique(String str) {
		
		String newStr = str.toLowerCase();
		
		for(int i = 0; i < newStr.length(); i++) {
			if(newStr.indexOf(newStr.charAt(i)) == newStr.lastIndexOf(newStr.charAt(i))) continue;
			else return false;
		}
		return true;
	}
	
	//using additional space 
	private boolean isItUnique(String str) {
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i < str.length(); i++) {
			if(set.contains(str.charAt(i))) return false;
			set.add(str.charAt(i));
		}
		
		return true;
	}
}


