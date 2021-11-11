package array;

public class WordSearch {

	public static void main(String[] args) {
		WordSearch search = new WordSearch();
		System.out.println(search.exist(new char[][] {{'A','B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, 
			{'A', 'D', 'E', 'E'}}, "ABCB"));
	}
	
	boolean visited [][];
    
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && hasWord(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean hasWord(char [][] board, String word, int i, int j, int index) {
        if (!visited[i][j] && board[i][j] == word.charAt(index)) {
            return true;
        }
        if (i < 0 || i > board.length || j < 0 || j > board[0].length || 
            board[i][j] != word.charAt(index) || visited[i][j]) return false;
        
        visited[i][j] = true;
        
        if (hasWord(board, word, i + 1, j, index + 1) || 
            hasWord(board, word, i - 1, j, index + 1) ||
            hasWord(board, word, i, j + 1, index + 1) ||
            hasWord(board, word, i, j - 1, index + 1)) {
            return true;
        }
        
        
        return false;
    }	

}
