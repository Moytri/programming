package expedia.com.all.frequencies.array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 *
 */
public class LeastUniqueInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }
            else {
                map.put(i, map.get(i) + 1);
            }            
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int key : map.keySet()) q.offer(key);

        while(k > 0 && !q.isEmpty()) k -= map.get(q.poll());
        
        // checking if k is negative, means: map -> [4=1, 3=3, 1=2, 2=1] and k=3
        // queue -> 2, 4, 1, 3
        // k = 3 :: map.get(queue.poll()) == map.get(2) ==> k = 3 - 1 = 2
        // k = 2 :: map.get(queue.poll()) == map.get(4) ==> k = 2 - 1 = 1
        // k = 1 :: map.get(queue.poll()) == map.get(1) ==> k = 1 - 2 = -1
        // means the size of queue is 1 since it only containing 3.
        // if we delete more than we want, than the actual total deleted items are less than k
        return k < 0 ? q.size() + 1 : q.size();
    }
}
