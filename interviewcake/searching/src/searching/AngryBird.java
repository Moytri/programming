package searching;

/**
 * 
 * @author Moytri
 * https://www.interviewcake.com/question/java/top-scores?course=fc1&section=sorting-searching-logarithms
 */
public class AngryBird {

	public static void main(String[] args) {
		
		sortScores(new int[]{37, 89, 41, 65, 91, 53}, 100);
	}
	
	public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {
		
		int countScores [] = new int[highestPossibleScore + 1];
		int sortedArray [] = new int [unorderedScores.length];
		int index = 0;
		
		for (int score: unorderedScores) {
			countScores[score]++;
		}
		
		for (int i = highestPossibleScore; i >=0; i--) {
			int count = countScores[i];
			
			for (int j = 0; j < count; j++) {
				sortedArray[index++] = i;
			}
		}
		
		return countScores;
	}

}
