package string;

public class ReverseString {

	public static void main(String[] args) {
		ReverseString reverseStr = new ReverseString();
		String str = "Topa";
		System.out.println(reverseStr.reverse(str));
	}
	
	public String reverse(String str) {
		int length = str.length();
		return reverse(str, 0, length - 1);
	}

	public String reverse(String str, int start, int end) {
		if (start > end) return "";
		return reverse(str, start + 1, end).concat(str.charAt(start)+"");
	}
}
