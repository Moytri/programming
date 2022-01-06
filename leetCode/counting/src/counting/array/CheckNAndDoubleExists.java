package counting.array;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * We can also solve it using binary search
 */
public class CheckNAndDoubleExists {

	public static void main(String[] args) {
		CheckNAndDoubleExists nAndDouble = new CheckNAndDoubleExists();
		System.out.println(nAndDouble.checkIfExist(new int [] {10,2,5,3}));
	}
	
	 public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : arr) {
            if (map.containsKey(i * 2) || ( i%2 == 0 && map.containsKey(i / 2))) {
                return true;
            }
            else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        
        return false;
    }	
}
