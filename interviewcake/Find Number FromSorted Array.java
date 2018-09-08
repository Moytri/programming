Suppose we had an array ? of nn integers sorted in ascending order. How quickly could we check if a given integer is in the array?

My Solution in Java:
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static boolean contains(int[] a, int n) {

        // check if an integer is present in the array
        int res = 0;
        int start = 0;
        int end = a.length - 1;
        
        res = contains(a, start, end, n);
        
        if(res != -1) return true;

        return false;
    } 
    
    public static int contains(int [] arr, int start, int end, int n) {
        
        int mid = (start + end)/2;
        
        if(arr.length == 0) return -1;
        
        if(arr.length == 1) {
            if(arr[0] == n) return 0;
            else return -1;
        }
        
        if(n < arr[0]) return -1;
        
        if(start <= end) {
            
            if(arr[mid] == n) return mid;
            
            if(arr[mid] < n) {
                return contains(arr, mid + 1, end, n);
            }
            
            if(arr[mid] > n) {
                return contains(arr, start, mid - 1, n);
            }
        }
        return -1;
    }






//This test cases are written by Interview Cake

    // tests

    @Test
    public void emptyArrayTest() {
        final boolean result = contains(new int[] {}, 1);
        assertFalse(result);
    }

    @Test
    public void oneItemArrayNumberPresentTest() {
        final boolean result = contains(new int[] {1}, 1);
        assertTrue(result);
    }

    @Test
    public void oneItemArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {1}, 2);
        assertFalse(result);
    }

    @Test
    public void smallArrayNumberPresentTest() {
        final boolean result = contains(new int[] {2, 4, 6}, 4);
        assertTrue(result);
    }

    @Test
    public void smallArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {2, 4, 6}, 5);
        assertFalse(result);
    }

    @Test
    public void largeArrayNumberPresentTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8);
        assertTrue(result);
    }

    @Test
    public void largeArrayNumberAbsentTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0);
        assertFalse(result);
    }

    @Test
    public void largeArrayNumberFirstTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 1);
        assertTrue(result);
    }

    @Test
    public void largeArrayNumberLastTest() {
        final boolean result = contains(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}