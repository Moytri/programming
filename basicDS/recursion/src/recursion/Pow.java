package recursion;

public class Pow {

	/**
	 * 
	 * @Author Moytri
	 * Problem: https://leetcode.com/problems/powx-n/
	 */
	public static void main(String[] args) {
		Pow myPow = new Pow();
	}
	
	public double findPow(double x, int n) {
		if (n == 0) return 1;
		if (n < 0) {
			n = (-1)*n;
			x = 1/x;
		}
		return n%2 == 0 ? findPow(x*x, n/2) : x * findPow(x*x, n/2);
	}
}
