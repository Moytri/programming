package cciRecursionDP;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

class PermutationWithoutDuplicate {

	static int x = 10;
	public static void main(String[] args) {
		List<String> ls  = new ArrayList<>();
		//new PermutationWithoutDuplicate().permute("abc", 0, 2);
		//System.out.println(new PermutationWithoutDuplicate().permute("abc", 0, 2, ls));
	}
	
	static class S {
		class P {
			
		}
	}
	
	public void permute(String str, int start, int end) {
		if(start == end) {
			System.out.print(str + " ");
		}
		else {
			for(int i = start; i <= end; i++) {
				str = swap(str, i, start);
				permute(str, start + 1, end);
				str = swap(str, i, start);
			}
		}
		class P {
			void show() {
				System.out.println(x);
			}
		}
	}
		
    public List<String> permute(String str, int start, int end, List<String> ls) {
        if(start == end) {
            ls.add(str);
        }
        else {
            for(int i = start; i <= end; i++) {
                str = swap(str, i, start);
                permute(str, start + 1, end, ls);
                str = swap(str, i, start);
            }
        }
        return ls;
    }

	private String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 

        return String.valueOf(charArray);
    } 
	

	

}
