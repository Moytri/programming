package searching;

class BinarySearch {

    public static void main(String [] args) {
        int [] arr = {1,2,3,4,5,6,7};
        int key = 3;
    
        BinarySearch bs = new BinarySearch();
        bs.binarySearch(key, 0, 6, arr);
    }
    
    public boolean binarySearch(int key, int low, int high, int [] arr) {
        if(low > high) {
            System.out.println("There is no " + key + " in the given sorted array.");
            return false;
        }

        int mid = low + (high - low)/2;

        if(arr[mid] == key) {
            System.out.println("Found!! The index of " + key + " is : " + mid);
            return true;
        }

        if(arr[mid] > key) {
            return binarySearch(key, low, mid-1, arr);
        }
        else {
            return binarySearch(key, mid+1, high, arr);
        }
    }
}
