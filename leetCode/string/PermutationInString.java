package string;
import java.util.Arrays;

/*https://leetcode.com/problems/permutation-in-string
*/
public class PermutationInString {

	public static void main(String[] args) {
		System.out.println(new PermutationInString().checkInclusion("ab", "xrbaad"));
	}
	
	public boolean checkInclusion(String s1, String s2) {
        int n1=s1.length(),n2=s2.length();
        int[] f1=new int[26];
        for(int i=0;i<n1;i++) f1[s1.charAt(i)-'a']++;
        
        int[] f2=new int[26];
        for(int j=0;j<n2;j++){
            f2[s2.charAt(j)-'a']++;
            if(j>=n1) f2[s2.charAt(j-n1)-'a']--;
            if(Arrays.equals(f2,f1)) return true;
        }
        return false;
    }

}
