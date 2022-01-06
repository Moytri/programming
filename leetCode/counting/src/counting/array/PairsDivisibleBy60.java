package counting.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Moytri
 *
 */
public class PairsDivisibleBy60 {

	public static void main(String[] args) {
		PairsDivisibleBy60 pairs = new PairsDivisibleBy60();
		System.out.println(pairs.numPairsDivisibleBy60(new int[] {30,20,150,100,40}));
	}
	
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        for (int i = 0; i < time.length; i++) {
            if (time[i] % 60 == 0) { 
                count += map.getOrDefault(0, 0);
            }
            else {
                count += map.getOrDefault(60 - (time[i] % 60), 0);
            }
            map.put(time[i] % 60, map.getOrDefault(time[i] % 60, 0) + 1);
        }
        
        return count;
    }	
}
