package trie;

public class TrieImplementation {
	private TrieNode root;
	
	public static void main(String[] args) {
		TrieImplementation trie = new TrieImplementation();
		trie.insert("apple");
		trie.insert("apple");
		System.out.println(trie.search("app")); 	// false
		System.out.println(trie.startsWith("app")); // true
	}
	
	public TrieImplementation() {
		this.root = new TrieNode();
	}
	
	public void insert(String word) {
		TrieNode node = root;
		
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if (!node.containsKey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		
		node.setEnd();
	}
	
	public boolean search(String word) {
		TrieNode node = searchWithPrefix(word);
		return node != null && node.isEnd();
	}
	
	private TrieNode searchWithPrefix(String word) {
		TrieNode node = root;
		
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			
			if (node.containsKey(ch)) {
				node = node.get(ch);
			}
			else {
				return null;
			}
		}
		return node;
	}
	
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchWithPrefix(prefix);
        return node != null;
    }
	
	class TrieNode {
		private TrieNode [] links;
		
		private final int limit = 26;
		
		private boolean isEnd;
		
		public TrieNode() {
			this.links = new TrieNode[limit];
		}
		
		public boolean containsKey(Character ch) {
			return links[ch - 'a'] != null;
		}
		
		public TrieNode get(Character ch) {
			return links[ch - 'a'];
		}
		
		public void put(Character ch, TrieNode node) {
			links[ch - 'a'] = node;
		}
		
		public void setEnd() {
			this.isEnd = true;
		}
		
		public boolean isEnd() {
			return isEnd;
		}
	}

}
