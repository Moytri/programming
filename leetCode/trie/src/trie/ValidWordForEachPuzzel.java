package trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/
 *
 */
public class ValidWordForEachPuzzel {

	public static void main(String[] args) {
		ValidWordForEachPuzzel puzzle = new ValidWordForEachPuzzel();
		String [] words = {"aaaa","asas","able","ability","actt","actor","access"};
		String [] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
		puzzle.findNumOfValidWords(words, puzzles);
	}
	
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Trie root = new Trie();
        for (String word : words){
            char[] cs = word.toCharArray();
            Arrays.sort(cs);
            StringBuffer sb = new StringBuffer();
            sb.append(cs[0]);
            for (int i=1;i<cs.length;i++){
                if (cs[i]!=cs[i-1])sb.append(cs[i]);
            }
            addWord(sb.toString(), root);
        }
        List<Integer> list = new ArrayList<>();
        for (String puzzle : puzzles){
            list.add(search(puzzle, root,  'a'));
        }
        return list;
    }


    private int search(String puzzle, Trie cur, char start){
        int count = 0;
        if (cur.word!=null && cur.word.indexOf(puzzle.charAt(0))!=-1){
            count+=cur.count;
        }
        for (char c = start; c<='z';c++){
            if (cur.children[c-'a']!=null && puzzle.indexOf(c)!=-1){
                count+=search(puzzle, cur.children[c-'a'], (char)(c+1));
            }
        }
        return count;
    }




    private void addWord(String word, Trie root){
        Trie cur = root;
        for (int i=0;i<word.length();i++){
            int j = word.charAt(i)-'a';
            if (cur.children[j]==null){
                cur.children[j] = new Trie();
            }
            cur = cur.children[j];
        }
        cur.word = word;
        cur.count++;
    }



    class Trie{
        Trie[] children = new Trie[26];
        String word = null;
        int count = 0;
    }	

}
