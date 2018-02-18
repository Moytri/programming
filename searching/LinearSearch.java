package searching;

class LinearSearch {

    public static void main(String [] arg) {
        int [] arr = {3,5,2,6,8,4,1,7};
        int key = 6;
        LinearSearch ls = new LinearSearch();
        ls.linearSearch(key, arr);
    }

    public boolean linearSearch(int key, int arr []) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == key) {
                System.out.println("Found! The index of " + key + " is : " + i);
                return true;
            } 
        }
        System.out.println("The given is not found.");
        return false;
    }
}
