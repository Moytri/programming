package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

/**
 * 
 * @author Moytri
 * Question: https://www.interviewcake.com/question/java/word-cloud?course=fc1&section=hashing-and-hash-tables
 */

public class WordCount {

    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();
        
        enum State { START, CONSUME };
        
        private void populateWordsToCounts(String inputString) {

            // fetch words without special character and space from the string
            List<StringBuilder> words = new ArrayList<>();
            words = getWords(inputString);
            int length = words.size();
            
            for (int i = 0; i < length; i++) {
                String word = words.get(i).toString();
                if (wordsToCounts.containsKey(words.get(i))) {
                    wordsToCounts.put(word, wordsToCounts.get(i) + 1);
                }
                else if (wordsToCounts.containsKey(word.toLowerCase())) {
                    wordsToCounts.put(word.toLowerCase(), 
                    wordsToCounts.get(word.toLowerCase()) + 1);
                }
                else if (wordsToCounts.containsKey(capitalize(word))) {
                    wordsToCounts.put(capitalize(word), 
                    wordsToCounts.get(capitalize(word)) + 1);
                }
                else {
                    wordsToCounts.put(word, 1);
                }
            }
        }
        
        public List<StringBuilder> getWords(String inputString){
            
            List<StringBuilder> words = new ArrayList<>();
            StringBuilder word = new StringBuilder();
            
            State state = State.START;
            int length = inputString.length();
            
            for (int i = 0; i < length; i++) {
                char ch = inputString.charAt(i);

                if (state == State.START) {
                    if (Character.isLetter(ch) || ch == '\'') {
                        word.append(ch);
                    }
                    state = State.CONSUME;
                }
                else {
                    if (Character.isLetter(ch) || ch == '\'') {
                        word.append(ch);
                        
                        // checking end of string
                        if (i == length - 1) {
                            words.add(word);
                        }
                    }
                    else if (ch == '.' || ch == ' ' || ch == '?' || ch == '!') {
                        // checking empty string/space e.g: ? , !
                        if (word.length() != 0) words.add(word);
                        word = new StringBuilder();
                    }
                    else if (ch == '-') {
                        if (i > 0 && Character.isLetter(inputString.charAt(i - 1))
                        && Character.isLetter(inputString.charAt(i + 1))) {
                            word.append(ch);
                        }
                        else {
                            if (word.length() != 0) words.add(word);
                            word = new StringBuilder();
                        }
                    }
                }
            }
            
            return words;
        }

        private String capitalize(String word) {
            return word.substring(0, 1).toUpperCase() + word.substring(1);
        }
        
        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }
















    // tests

    // There are lots of valid solutions for this one. You
    // might have to edit some of these tests if you made
    // different design decisions in your solution.

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("I", 1);
            put("like", 1);
            put("cake", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("and", 1);
            put("pound", 1);
            put("for", 2);
            put("dessert", 1);
            put("Chocolate", 1);
            put("dinner", 1);
            put("cake", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Strawberry", 1);
            put("short", 1);
            put("Yum", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("cake", 1);
            put("Dessert", 1);
            put("mille-feuille", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
                put("mmm", 2);
                put("decisions", 2);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() { {
            put("Bakery", 1);
            put("Cakes", 1);
            put("Allie's", 1);
            put("Sasha's", 1);
        }};
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(WordCount.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
