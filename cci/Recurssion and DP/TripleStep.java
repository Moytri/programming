package cciRecursionDP;

/*
 * Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
*/

public class TripleStep {

	public static void main(String[] args) {
		System.out.println(countSteps(1));
		System.out.println(countSteps(2));
		System.out.println(countSteps(4));
		System.out.println(countSteps(5));
		System.out.println(countSteps(10));
		System.out.println(countSteps(15));
	}	
	public final static int countSteps(int stairsNumbers) {

		if(stairsNumbers == 0) return 1;
		if(stairsNumbers == 1) return 1;
		if(stairsNumbers == 2) return 2;

		return countSteps(stairsNumbers - 1) + countSteps(stairsNumbers - 2) + 
				countSteps(stairsNumbers - 3);
	}

}
