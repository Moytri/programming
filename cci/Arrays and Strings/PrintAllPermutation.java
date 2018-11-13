package cciArrayString;

public class PrintAllPermutation {

	public static void main(String[] args) {
		printPermutaion("abc");
	}
	
	public static void printPermutaion(String str) {
		printPermutaion("", str);
	}
	
	private static void printPermutaion(String word, String str) {
		if(str.isEmpty()) {
			System.out.println(word+str);
		}
		else {
			for(int i = 0; i < str.length(); i++) {
				printPermutaion(word+str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
			}
		}
	}

}
