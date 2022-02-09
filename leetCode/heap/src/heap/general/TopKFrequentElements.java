package heap.general;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/top-k-frequent-elements/
 *
 */
public class TopKFrequentElements {
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		sb.append('a');
		System.out.println(sb.toString());
	}
	
	public int[] topKFrequent(int[] nums, int k) {
        int result [] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        
        PriorityQueue<Integer []> queue = new PriorityQueue<Integer []>((n1, n2) -> n2[1] - n1[1]);
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Integer[] {entry.getKey(), entry.getValue()});
        }
        
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll()[0];
        }
        
        return result;
    }	

}
