package array.difference;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/car-pooling/
 *
 */
public class CarPooling {

	public static void main(String[] args) {
		CarPooling carPooling = new CarPooling();
		System.out.println(carPooling.carPooling(new int[][] 
												{
													{2,1,5},
													{3,3,7}
												}, 5));
	}
	
	/**
	 * 
	 * For each location, we will track the passenger number in an external memory like array/map
	 * For each start location we will add the passenger number and subtract for the end location
	 * We will loop through the map/array to check if passengers satisfy the capacity
	 */
	public boolean carPooling(int[][] trips, int capacity) {
		int count [] = new int[1001];
		
		for (int[] trip : trips) {
			count[trip[1]] += trip[0];
			count[trip[2]] -= trip[0];
		}
		
		int usedCapacity = 0;		
		for (int i = 0; i < count.length; i++) {
			usedCapacity += count[i];
			
			if (usedCapacity > capacity) return false;
		}
		return true;
	}

}
