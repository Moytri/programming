package general;

import java.util.PriorityQueue;

public class FindMedian {

	int minQueueCount = 0; int maxQueueCount = 0;
	PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>((a,b) -> b - a);
	PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
	
	public static void main(String[] args) {
		int [] arr = {50, 60, 40, 55, 70};
		
		FindMedian findMedian = new FindMedian();
		findMedian.insert(arr);
	}
	
	public void insert(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			insetIntoQueue(arr[i]);
			balance();
			System.out.println(getMedian());
		}
	}
	
	public void insetIntoQueue(int val) {
		if (maxQueue.isEmpty() && minQueue.isEmpty()|| val < maxQueue.peek()) {
			maxQueue.add(val);
			maxQueueCount++;
		}
		else {
			minQueue.add(val);
			minQueueCount++;
		}
	}
	
	public void balance() {
		if (maxQueueCount - minQueueCount > 1) {
			int val = maxQueue.poll();
			maxQueueCount--;
			minQueue.add(val);
			minQueueCount++;			
		}
		else if (minQueueCount - maxQueueCount > 0) {
			int val = minQueue.poll();
			minQueueCount--;
			maxQueue.add(val);
			maxQueueCount++;
		}
	}
	
	public double getMedian() {
		if (minQueueCount == maxQueueCount) {
			return (minQueue.peek() + maxQueue.peek())/2;
		}
		return maxQueue.peek();
	}

}
