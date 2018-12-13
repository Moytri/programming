package cciRecursionDP;

/*Parens: Implement an algorithm to print all valid (i.e., properly opened and closed) combinations
of n pairs of parentheses.
EXAMPLE
Input: 3
Output: (( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()*/

public class Parens {

	public static void main(String[] args) {
		new Parens().parens(3);
	}
	
	public void parens(int bracesNumber) {
		String sb = new String();
		parens(sb, bracesNumber, 0);
	}
	
	public void parens(String sb, int openBraces, int closeBraces) {
		if(openBraces != 0) {
			parens(sb.concat("("), openBraces - 1, closeBraces + 1);
		}
		if(closeBraces != 0) {
			parens(sb.concat(")"), openBraces, closeBraces - 1);
		}
		if(openBraces == 0 && closeBraces == 0) {
			System.out.println(sb);
		}
	}

}
