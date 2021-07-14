package com.interview.cake.array;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseWordConsiderRT {

    public static void reverseWords(char[] message) {
        int length = message.length;
        
        reverse(message, 0, length - 1);

        for (int i = 0; i < length; ) {
            int j = searchEnd(message, i, length - 1);
            reverse(message, i, j);
            i = j + 2;
        }
        
    }
    
    public static void print(char [] message) {
        for (int i = 0; i < message.length; i++) {
            System.out.println(message[i]);
        }        
    }
    
    public static void reverse(char [] message, int start, int end){
        // swap charecters
        while (end > start) {
            char temp = message[start];
            message[start] = message[end];
            message[end] = temp;
            
            start++;
            end--;
        }
    }
    
    public static int searchEnd(char [] message, int start, int end) {
        while (end >= start) {
            if (message[start] == ' ') {
               break;
            }
            start++;
        }
        return start - 1;
    }


















    // tests

    @Test
    public void oneWordTest() {
        final char[] expected = "vault".toCharArray();
        final char[] actual = "vault".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoWordsTest() {
        final char[] expected = "cake thief".toCharArray();
        final char[] actual = "thief cake".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeWordsTest() {
        final char[] expected = "get another one".toCharArray();
        final char[] actual = "one another get".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsSameLengthTest() {
        final char[] expected = "the cat ate the rat".toCharArray();
        final char[] actual = "rat the ate cat the".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsDifferentLengthsTest() {
        final char[] expected = "chocolate bundt cake is yummy".toCharArray();
        final char[] actual = "yummy is cake bundt chocolate".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ReverseWordConsiderRT.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
