package cciRecursionDP;

/*
 * Recursive Multiply: Write a recursive function to multiply two positive integers without using
the * operator (or / operator). You can use addition, subtraction, and bit shifting, but you should
minimize the number of those operations.
*/

public class RecurssiveMultiply {

	public static void main(String[] args) {
		System.out.println(new RecurssiveMultiply().multiply(11, 12));
		System.out.println(new RecurssiveMultiply().getMin(8, 11));
	}
	
	/*my solution*/
	public int multiply(int n, int m) {
		int p = n - m > 0 ? m : n;
		int q = p == m ? n : m;
		if(p == 1) return q;
		return q + multiply(q, p - 1);
	}
	
	/*solution of cracking coding interview*/
	public int getMin(int n, int m) {
		int smaller = n < m ? n : m;
		int bigger = n < m ? m : n;
		return multiplication(smaller, bigger);
	}

	private int multiplication(int smaller, int bigger) {
		if(smaller == 0) return 0;
		if(smaller == 1) return bigger;
		
		int div = smaller / 2;
		int halfProd = multiplication(div, bigger);
		
		if(smaller % 2 == 0) return halfProd + halfProd;
		else return halfProd + halfProd + bigger;
	}

}
