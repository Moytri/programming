package com.interview.cake.array;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class ReverseWord {

    public static void reverseWords(char[] message) {
        
        String sentence = "";
        int length = message.length - 1;
        
        // decode the message by reversing the words
        for (int i = 0; i <= length; i++) {
            if (message[i] != ' ') {
                sentence += message[i];
            }
            else {
                sentence += " ";
            }
        }
        
        System.out.println(sentence);
        String [] words = sentence.split(" ");
        int start = 0;
        int end = words.length - 1;      
                
        while (end > start) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            
            start++;
            end--;
        }
        
        sentence = "";
        
        for (int i  = 0; i < words.length; i++) {
            if (i == 0) {
                sentence += words[i];
            }
            else {
                sentence += " " + words[i];
            }
        }
        
        System.out.println(sentence);
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
        Result result = JUnitCore.runClasses(ReverseWord.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}