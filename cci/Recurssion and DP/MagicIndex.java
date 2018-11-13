package cciRecursionDP;

/*Magic Index: A magic index in an array A[ 1 .•. n-1] is defined to be an index such that A[ i]
i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in
array A.*/

public class MagicIndex {

	public static void main(String[] args) {
		int [] arr = {1,2,3,5,7};
		System.out.println(magicIndex(arr));
	}
	
	public static int magicIndex(int [] arr) {
		int start = 0, end = arr.length - 1;
		return magicIndex(arr, start, end);
	}

	private static int magicIndex(int[] arr, int start, int end) {
		if(end < start) return -1;
		int mid = (start + end)/2;
		if(arr[mid] == mid) return mid;
		if(mid < arr[mid]) return magicIndex(arr, 0, mid-1);
		return magicIndex(arr, mid + 1, end);
	}

}
