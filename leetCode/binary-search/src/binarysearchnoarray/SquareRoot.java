package binarysearchnoarray;

/**
 * 
 * @author Moytri
 * Problem: 
 *
 */
public class SquareRoot {

	public static void main(String[] args) {
		SquareRoot sqrRt = new SquareRoot();
		System.out.println(sqrRt.mySqrt(73));
	}
	
    public int mySqrt(int x) {
        int start = 0; int end = x/2;
        
        while(start <= end) {
            int mid = start + (end - start)/2;
            long sqr = mid * mid;

            if (sqr < x) {
                start = mid + 1;
            }
            else if (sqr > x) {
                end = mid - 1;
            }
            else return mid;
        }
        
        return end;
    }	

}
