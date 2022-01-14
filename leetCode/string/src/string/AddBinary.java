package string;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/add-binary/
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		AddBinary addBinary = new AddBinary();
		System.out.println(addBinary.addBinary("110", "11"));
	}
	public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        int length1 = a.length();
        int length2 = b.length();
        int carry = 0;
        
        while (length1 >= 1 && length2 >= 1) {
            int result = a.charAt(length1 - 1) - '0' + 
                         b.charAt(length2 - 1) - '0' + 
                         carry;
            
            sb.append(result%2);
            carry = result/2;
            length1--;
            length2--;
        }
        
        while (length1 >= 1) {
            int result = a.charAt(length1 - 1) - '0' +  carry;            
            sb.append(result%2);
            carry = result/2;
            length1--;
        }
        
        while (length2 >= 1) {
            int result = b.charAt(length2 - 1) - '0' +  carry;            
            sb.append(result%2);
            carry = result/2;
            length2--;
        }        
        
        if (carry == 1) sb.append(carry);
        sb.reverse();
        
        return sb.toString();
    }	

}
