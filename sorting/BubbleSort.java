package sorting;

class  BubbleSort {

	public static void main(String [] args){
		
		int [] arr = {10, 4, 3, 5, 7, 9};
                BubbleSort sortedArr = new BubbleSort();

		arr = sortedArr.bubbleSort(arr);

                //print the sorted array
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}	
	}

	private int[] bubbleSort(int [] arr) {

		for(int i = 0; i<arr.length; i++){             //for each pass
			for(int j = 0; j<arr.length-1; j++){   //for the comparism between adjacent elements in each pass
				if(arr[j] > arr[j+1]) {

					//swap the elements					 
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}
}
