package cciRecursionDP;

/*Magic Index: A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.
FOLLOW UP
What if the values are not distinct?*/

public class MagicIndexFollowup {

	public static void main(String[] args) {
		int [] arr = {-10,-5,1,1,1,3,4,5,9,12,13};
		System.out.println(magicIndex(arr));
	}
	
	public static int magicIndex(int [] arr) {
		int start = 0, end = arr.length - 1;
		return magicIndex(arr, start, end);
	}

	private static int magicIndex(int[] arr, int start, int end) {
		if(end < start) return -1;
		
		int mid = (start + end) / 2;
		if(mid == arr[mid]) return mid;
		
		int result = -1;
		if(mid > arr[mid]) {
			if(arr[mid] >=0) { 
				result = magicIndex(arr, start, arr[mid]);
			}
			if( result == -1 ) {
				return magicIndex(arr, mid + 1, end);
			}
		} else {
			result = magicIndex(arr, arr[mid], end);
			if( result == -1 ) {
				return magicIndex(arr, start, mid - 1);
			}
		}
		return result;
	}

}
