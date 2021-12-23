package dp;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	public static void main(String[] args) {
		PascalTriangleII pascalTriangle = new PascalTriangleII();
		System.out.println(pascalTriangle.getRow(3));
	}
	
	public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (rowIndex < 0) return triangle.get(rowIndex);
        
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j < i + 1; j++) {
                if ( j == 0 || j == i) {
                    row.add(1);
                }
                else {
                    row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
                }
            }
            triangle.add(row);
        }
        
        
        return triangle.get(rowIndex);
    }	

}
