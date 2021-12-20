
//[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
public class NumberOfProvices {

	public static void main(String[] args) {
		NumberOfProvices numberOfProvices = new NumberOfProvices();
		
		int[][] isConnected = new int[][] {
			{1,0,0,1},
			{0,1,1,0},
			{0,1,1,1},
			{1,0,1,1}
		};
		System.out.println(numberOfProvices.findCircleNum(isConnected));

	}
	
	 public int findCircleNum(int[][] isConnected) {
	        int row = isConnected.length; int col = isConnected[0].length;
	        int count = 0;
	        
	        for (int i = 0; i < row; i++) {
	            for (int j = 0; j < col; j++) {
	                if (isConnected[i][j] == 1) {
	                    dfs(isConnected, i, j, row, col);
	                    count++;
	                }
	            }
	        }
	        
	        return count;
	    }
	    
	    public void dfs(int[][] isConnected, int i, int j, int row, int col) {
	        if (i < 0 || i >= row || j < 0 || j >= col || isConnected[i][j] != 1) return;
	        
	        isConnected[i][j] = 0;
	        
	        dfs(isConnected, i + 1, j, row, col);
	        dfs(isConnected, i - 1, j, row, col);
	        dfs(isConnected, i, j + 1, row, col);
	        dfs(isConnected, i, j - 1, row, col);
	    }	

}
