package bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	
	public static void main (String [] args) {
		GrayCode grayCodes = new GrayCode();
		grayCodes.grayCode(3);
	}
	
	public List<Integer> grayCode(int n) {
        List<Integer> grayCodes = new ArrayList<>();
        
        grayCodes.add(0);
        
        for(int i = 0; i < n; i++) {
            int length = grayCodes.size();
            
            for (int j = length - 1; j >= 0; j--) {
                grayCodes.add(grayCodes.get(j) | 1 << i);
            }
        }
        
        return grayCodes;
    }
}
