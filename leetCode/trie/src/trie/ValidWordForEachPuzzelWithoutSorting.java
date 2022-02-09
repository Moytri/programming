package trie;

import java.util.ArrayList;
import java.util.List;

public class ValidWordForEachPuzzelWithoutSorting {

	public static void main(String[] args) {
		ValidWordForEachPuzzelWithoutSorting puzzle = new ValidWordForEachPuzzelWithoutSorting();
//		String [] words = {"aaaa","asas","able","ability","actt","actor","access"};
//		String [] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
		String [] words = {"aaaa","asas"};
		String [] puzzles = {"aboveyz","abrodyz"};
		List<Integer> result = puzzle.findNumOfValidWords(words, puzzles);
		
		for (int data : result) {
			System.out.println(data);
		}
	}
	
	class TrieNode {
		public TrieNode [] nodes;
		public int wordCount;
		
		public TrieNode() {
			nodes = new TrieNode[26];
			wordCount = 0;
		}
	}
	
	public List<Integer> findNumOfValidWords(String [] words, String [] puzzles) {
		TrieNode root = new TrieNode();
		
		for (String word : words) {
			TrieNode curr = root;
			
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (curr.nodes[ch - 'a'] == null) {
					curr.nodes[ch - 'a'] = new TrieNode();
				}
				curr = curr.nodes[ch - 'a'];
			}
			curr.wordCount++;
		}
		
		List<Integer> result = new ArrayList<Integer>();
		for (String puzzle : puzzles) {
			result.add(DFS(root, puzzle, false));
		}
		return result;
	}
	
	private int DFS(TrieNode node, String puzzle, boolean hasFirst) {
		int result = hasFirst ? node.wordCount : 0;
		
		for (int i = 0; i < puzzle.length(); i++) {
			char c = puzzle.charAt(i);
			if(node.nodes[c - 'a'] != null)
                result += DFS(node.nodes[c - 'a'], puzzle, hasFirst || c == puzzle.charAt(0));
		}
		return result;
	}

}
