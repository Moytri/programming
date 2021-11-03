package amazon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/word-ladder/
 * Type: BFS, DFS, Hash
 *
 */
public class WordLadder {

	public static void main(String[] args) {
		WordLadder ladder = new WordLadder();
		
		List<String> wordList = new LinkedList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");

		ladder.ladderLength("hit", "cog", wordList);
	}
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        //System.out.println(dictionary.size());
        if (!dictionary.contains(endWord)) return 0;
        
        // add beginWord to the queue for starting the bfs
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        // remove the begin word from the dictionary to track the vistied word
        dictionary.remove(beginWord);
        int count = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            // dont understand why
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char [] currentWordArr = currentWord.toCharArray();
                
                for (int j = 0; j < currentWord.length(); j++) {
                    char originalChar = currentWordArr[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currentWordArr[j] = ch;
                        
                        String nextWord = new String(currentWordArr);
                        
                        if (nextWord.equals(endWord)) return count + 1;
                        
                        if (dictionary.contains(nextWord)) {
                            queue.add(nextWord);
                            dictionary.remove(nextWord);
                        }
                    }
                    // going back to original word. e.g: hit became git, before changing the next index revert g to h
                    currentWordArr[j] = originalChar;
                }
            }
            count++;
        }
        return 0;
    }	
	
}
