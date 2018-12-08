package ccisortingsearching;

/*Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
number of times, write code to find an element in the array. You may assume that the array was
originally sorted in increasing order.
EXAMPLE
lnput:find5in{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
Output: 8 (the index of 5 in the array)*/

public class SearchInRotatedArray {

	public static void main(String[] args) {
		int [] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println(new SearchInRotatedArray().getIndex(arr, 0, 11, 5));
	}
	
	public int getIndex(int [] arr, int left, int right, int number) {
		int mid = (left + right)/2;
		
		if(arr[mid] == number) return mid;
		
		if(arr[left] <= arr[mid]) {
			//not rotated
			if(arr[mid] < arr[right]) {
				if(number <= arr[mid]) return getIndex(arr,left,mid,number);
				if(number > arr[mid]) return getIndex(arr,mid + 1,right,number);
			}
			//rotated and transition is in the right portion
			if(arr[mid] > arr[right]) {
				if(number <= arr[mid]) {
					if(arr[left] <= number) return getIndex(arr,left,mid,number); //left and right both are smaller than mid, identify which shorter is valid
					else {
						return getIndex(arr,mid + 1,right,number);
					}
				}
					
			}
		}
		else {
			//rotated and right portion is sorted
			//left portion is shifted sorted
			if(arr[mid] <= arr[right]) {
				if(number > arr[mid]) {
					if(number >= arr[mid] && number <= arr[right]) {
						return getIndex(arr,mid + 1,right,number);
					}
					else {
						return getIndex(arr,left,mid,number);
					}
				}
			}
		}
		
		return mid;
	}

}
