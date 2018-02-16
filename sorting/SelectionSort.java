package sorting;

class SelectionSort {

     public static void main ( String [] args) {
            int arr [] = {2,3,5,1,4};

            SelectionSort sortObj = new SelectionSort();
            arr = sortObj.selectionSort(arr);
         
            for(int i = 0; i< arr.length; i++) {
                System.out.print(arr[i] + " " );
            }
     }

     public int [] selectionSort (int [] arr) {
        int max = 0;
        int index = 0;
        for(int i = 0; i< arr.length; i++) {
            max = arr[i];

            for(int j = i; j< arr.length; j++) {
                if(max < arr[j]) {
                    max = arr[j];
                    index = j;
                }
            }
            
            if(i != index) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        return arr;
    }

    
}

