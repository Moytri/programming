package array;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/watering-plants/
 *
 */
public class WateringPlants {

	public static void main(String[] args) {
		WateringPlants wateringPlants = new WateringPlants();
		wateringPlants.wateringPlants(new int [] {2,2,3,3}, 5);
	}
	public int wateringPlants(int[] plants, int capacity) {
		AtomicInteger step = new AtomicInteger();
		countSteps(plants, 0, plants.length, capacity, capacity, step);
		return step.get();
	}
	    
	public void countSteps(int [] plants, int current, int length, int capacity, int initialCapacity, AtomicInteger step)     {
	    if (current == length) {
	    	return;
	    }
	    if (plants[current] <= capacity) {
	        step.getAndAdd(1);
	        countSteps(plants, current + 1, length, capacity - plants[current], initialCapacity, step);
	    } else {
	        step.getAndAdd(2 * current);
	        countSteps(plants, current, length, initialCapacity, initialCapacity, step);
	    }
	}
}
