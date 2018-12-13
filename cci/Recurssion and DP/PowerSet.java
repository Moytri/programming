package cciRecursionDP;

/*8.4 Power Set: Write a method to return all subsets of a set.*/
import java.util.ArrayList;
import java.util.List;

public class PowerSet {

	public static void main(String[] args) {
		int [] arr = {1,2,3};
		//new PowerSet().subsets(arr);
		System.out.println(new PowerSet().subsets(arr));
	}
	
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0, nums.length - 1);
    }
    
    private  List<List<Integer>> subsets(int[] nums, int start, int end) {
        List<List<Integer>> outerLs = new ArrayList<>(); //this is my final output
        List<Integer> innerLs = new ArrayList<>();       //this is the inner list of final outer list
        List<Integer> myLs = new ArrayList<>();          // this will return the list of the outer list
        List<Integer> myNewLs = new ArrayList<>();      //I will take each inner loop and add the start to it
        
        outerLs.add(new ArrayList<>());
        
        //when start == end means one data
        if(start == end) {
            innerLs.add(nums[start]);
            outerLs.add( innerLs);  
            return outerLs;
        }

        outerLs = subsets(nums, start + 1, end);
        int size = outerLs.size();

        for(int i = 0; i < size; i++) {
            myLs = outerLs.get(i);
            myNewLs.add(nums[start]);
            
            for(int k = 0; k < myLs.size(); k++) {
                myNewLs.add(myLs.get(k));
            }

            outerLs.add(myNewLs);
            myNewLs = new ArrayList<>(); //for each iteration instantiate a new list
        }

        return outerLs;
    } 
}
