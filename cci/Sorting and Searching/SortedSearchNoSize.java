package ccisortingsearching;

/*Sorted Search, No Size: You are given an array-like data structure Listy which lacks a size
method. It does, however, have an elementAt ( i) method that returns the element at index i in
0( 1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
structure only supports positive integers.) Given a Listy which contains sorted, positive integers,
find the index at which an element x occurs. If x occurs multiple times, you may return any index.*/

public class SortedSearchNoSize {

	public static void main(String[] args) {
		SortedSearchNoSize searchedItem = new SortedSearchNoSize();
		Listy myListy = searchedItem.new Listy(10);
		int prev = -1;
		System.out.println(searchedItem.search(myListy, 0, prev, 11));
	}
	
	public int search(Listy myListy, int start, int prev, int number) {
		
		//if start exceed the myListy limit minimize start by half
		//until it is within myListy limit and greater than equals to prev
		while(myListy.elementAt(start) == -1 && start >= prev) {
			start = (prev + start) / 2;
			
			//If start and prev equal and number is in-equal means the number not in the myListy
			if(start == prev && myListy.elementAt(start) != number) return -1;
		}
		
		if(myListy.elementAt(start) == number) return start;
		
		if(myListy.elementAt(start) < number) {
			prev = start;			
			if(start == 0) {
				start = start + 2;
			}
			else {
				start = start * 2;
			}
			return search(myListy, start, prev, number);
		}

		return binarySearch(myListy, prev, start, number);
	}
	
	private int binarySearch(Listy myListy, int start, int end, int number) {
		if (end >= start) {
			int mid = (start + end)/2;
			if(myListy.elementAt(mid) == number) return mid;
			if(number < myListy.elementAt(mid)) return binarySearch(myListy, start, mid - 1, number);
			else binarySearch(myListy, mid + 1, end, number);
		}
		return -1;
	}

	class Listy {
		int [] arr;
		public Listy(int size) {
			arr = new int[size];
			for(int i = 0; i < size; i++) {
				arr[i] = i + 2;
			}
		}
		
		public int [] myList() {
			return arr;
		}
		
		public int elementAt(int index) {
			try {
				return arr[index];
			}
			catch(ArrayIndexOutOfBoundsException exception) {
				return -1;
			}
		}
	}

}
