
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
        int[] visited = new int[row];
        
        for (int i = 0; i < row; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int[][] isConnected, int[] visited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(isConnected, visited, j);
            }
        }
    }	 
}
