package easy.string;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		ReverseString reverseStr = new ReverseString();		
		reverseStr.ReverseString(new char [] {'a','p', 'p', 'l', 'e'});
	}

    public void ReverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while(i <= j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++; j--;
        }
    }
}
