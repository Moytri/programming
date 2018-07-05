package sorting;

class InsertionSort {

	public static void main(String [] args) {

		int [] arr = {9, 6, 5, 0, 8, 2, 7, 1, 3};
		arr = insertionSort(arr);

		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	private static int [] insertionSort(int [] arr) {

		for(int i = 0; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
		
			while(j > -1 && key < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
	}
}
