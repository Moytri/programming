package sorting;

class MergeSort {

    public static void main (String [] args) {
        System.out.println("Hello");
        int [] arr = {4,9,7,6,5,3,1};
        MergeSort mergeObj = new MergeSort();
        arr = mergeObj.mergeSort(arr);

        for(int i = 0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
   
    public int [] mergeSort(int [] arr) {
        int n = arr.length;
        int [] left;
        int [] right;

        if(n%2 == 0) {
            left = new int[n/2];
            right = new int[n/2];
        }

        else {
            left = new int[n/2];
            right = new int[n/2 + 1];
        }

        for(int i = 0; i<n; i++) {
            if(i < n/2) {
                left[i] = arr[i];
            }
            else{
                right[i-n/2] = arr[i];
            }
        }

        if(n < 2) {
            return merge(left, right);
        }
        else {
            left = mergeSort(left);
            right = mergeSort(right);
        }
    
        return merge(left, right);
    }

    private int[] merge(int left[], int right[]) {
        int result []  = new int[left.length+right.length];
        int index = 0;
        int i = 0;
        int j = 0;

        /** until one subarray is deplet **/
        while(i< left.length && j< right.length) {
            if(left[i] < right[i]) {
                result[index++] = left[i++];
            }
            else {
                result[index++] = right[j++];
            }
        }

        /** add every leftover elements from the subarray **/
        while(i< left.length) {
            result[index++] = left[i++];
        }

        /** only one while loop is executed between last two while loop **/
        while(j< right.length) {
            result[index++] = right[j++];
        }

        return result;
    }

} 
