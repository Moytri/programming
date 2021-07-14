package com.interview.cake.array;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * 
 * @author Moytri
 * Question: https://www.interviewcake.com/question/java/reverse-string-in-place?course=fc1&section=array-and-string-manipulation
 *
 */
public class ReverseString {
	public static void reverse(char[] arrayOfChars) {

        int start = 0;
        int end = arrayOfChars.length - 1;
        
        // reverse input array of characters in place
        while (end > start) {
            char temp = arrayOfChars[end];
            arrayOfChars[end] = arrayOfChars[start];
            arrayOfChars[start] = temp;
            start++;
            end--;
        }
	}
	

    // tests

    @Test
    public void emptyStringTest() {
        final char[] actual = "".toCharArray();
        reverse(actual);
        final char[] expected = "".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void singleCharacterStringTest() {
        final char[] actual = "A".toCharArray();
        reverse(actual);
        final char[] expected = "A".toCharArray();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void longerStringTest() {
        final char[] actual = "ABCDE".toCharArray();
        reverse(actual);
        final char[] expected = "EDCBA".toCharArray();
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseString.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}


