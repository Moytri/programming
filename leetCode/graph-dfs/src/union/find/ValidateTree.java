package union.find;

public class ValidateTree {

	public static void main(String[] args) {
		ValidateTree tree = new ValidateTree();
		
		int[][] edges = new int[][] {
			{0, 1},
			{2, 3}
		};
		System.out.println(tree.validTree(4, edges));
	}
	
	 public boolean validTree(int n, int[][] edges) {
	        if (edges.length != n - 1) return false;
	        
	        UnionFind uf = new UnionFind(n);
	        
	        for (int[] edge : edges) {
	            int a = edge[0];
	            int b = edge[1];
	            
	            if (!uf.union(a,b)) {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	    
	    class UnionFind {
	    
	    private int[] root;
	    private int[] rank; // We use this to keep track of the size of each set.
	    
	    // For efficiency, we aren't using makeset, but instead initialising
	    // all the sets at the same time in the constructor.
	    public UnionFind(int n) {
	        root = new int[n];
	        rank = new int[n];
	        for (int node = 0; node < n; node++) {
	            root[node] = node;
	            rank[node] = 1;
	        }
	    }
	    
	    public int find(int x) {
	        if (x == root[x]) return root[x];
	        return root[x] = find(root[x]);
	    }

	        boolean union(int x, int y) {
	            int rootX = find(x);
	            int rootY = find(y);
	            
	            if (rootX == rootY) return false;

	            if (rank[rootX] < rank[rootY]) {
	                root[rootX] = rootY;
	                rank[rootX] += rank[rootY];
	            } else {
	                root[rootY] = rootX;
	                rank[rootY] += rank[rootX];
	            }

	            return true;
	        }        
	    }
}
