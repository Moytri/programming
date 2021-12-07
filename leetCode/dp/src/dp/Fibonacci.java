package dp;

public class Fibonacci {

	int memo [];
	public static void main(String[] args) {
		Fibonacci myFibonacci = new Fibonacci();
		int n = 6;
		
		myFibonacci.memo = new int[n];
		System.out.println(myFibonacci.fibonacci(n));
	}
	
	public int fibonacci(int n) {
		if (n == 0 || n == 1) return n;
		memo[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return memo[n];
	}

}
