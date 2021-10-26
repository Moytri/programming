package microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Moytri
 * Question: https://leetcode.com/problems/spiral-matrix/
 *
 */
public class SpiralMatrix {

	public static void main(String[] args) {
		SpiralMatrix spirlMatrix = new SpiralMatrix();
		int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> spiral = spirlMatrix.spiralOrder(matrix);
		
		for (Integer item: spiral) {
			System.out.println(item);
		}
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> spiral = new ArrayList<>();
		if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return spiral;
		
		int startRow = 0; int startCol = 0; int endRow = matrix.length - 1; int endCol = matrix[0].length - 1;
		getSpiralOrder(matrix, startRow, endRow, startCol, endCol, spiral);
		return spiral;
	}
	
	private void getSpiralOrder(int[][] matrix, int startRow, int endRow, int startCol, int endCol, List<Integer> spiral) {
		while (startRow <= endRow && startCol <= endCol) {
			for (int i = startCol; i <= endCol; i++) {
				spiral.add(matrix[startRow][i]);
			}
			startRow++;
			if (startRow > endRow) return;
			
			for (int i = startRow; i <= endRow; i++) {
				spiral.add(matrix[i][endCol]);
			}
			endCol--;
			if (endCol < startCol) return;
			
			for (int i = endCol; i >= startCol; i--) {
				spiral.add(matrix[endRow][i]);
			}
			endRow--;
			if (endRow < startRow) return;
			
			for (int i = endRow; i >= startRow; i--) {
				spiral.add(matrix[i][startCol]);
			}
			startCol++;
			if (startCol > endCol) return;
		}
	}

}
