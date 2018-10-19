/**
 * 1.6: String Compression
 * Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a-z).
 */

package cciArrayString;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(getCompressedString("a"));
	}
	
	public static String getCompressedString(String str) {
		StringBuilder sb = new StringBuilder();
		int characterCount = 0;
		
		for(int i = 0; i < str.length(); i++) {
			characterCount++;
			
			if(i+1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				sb.append(str.charAt(i));
				sb.append(characterCount);
				characterCount = 0;
			}
		}
		return sb.toString();
	}

}
