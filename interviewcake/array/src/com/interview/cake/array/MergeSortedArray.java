package com.interview.cake.array;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * 
 * @author Moytri
 * Question: https://www.interviewcake.com/question/java/merge-sorted-arrays?course=fc1&section=array-and-string-manipulation
 */
public class MergeSortedArray {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {
        
        int lengthMy = myArray.length;
        int lengthAlice = alicesArray.length;
        int length = lengthMy + lengthAlice;
        
        int [] combine = new int [length];
        int i = 0, j = lengthMy - 1, a = 0, b = lengthAlice - 1;
        int index = 0;
        

        // combine the sorted arrays into one large sorted array
        while (j >= i && b >= a) {
            if (myArray[i] <= alicesArray[a]) {
                combine[index++] = myArray[i++];
            }
            else {
                combine[index++] = alicesArray[a++];
            }
        }
        
        while (j >= i && b <= a) {
            combine[index++] = myArray[i++];
        }
        
        while (b >= a && j <= i) {
            combine[index++] = alicesArray[a++];
        }
        
        return combine;
    }


















    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    // @Test
    // public void arraysAreDifferentLengthsTest() {
    //     final int[] myArray = {2, 4, 6, 8};
    //     final int[] alicesArray = {1, 7};
    //     final int[] expected = {1, 2, 4, 6, 7, 8};
    //     final int[] actual = mergeArrays(myArray, alicesArray);
    //     assertArrayEquals(expected, actual);
    // }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MergeSortedArray.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}