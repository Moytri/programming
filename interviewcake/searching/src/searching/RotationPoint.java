package searching;

public class RotationPoint {
	 	public static int findRotationPoint(String[] words) {

	        // find the rotation point in the array
	        return findRotationPoint(words, 0, words.length - 1);
	    }
	    
	    public static int findRotationPoint(String[] words, int start, int end) {
	        if(start > end) {
	            return -1;
	        }
	        
	        if(start == end) {
				return end;
			}
			
	        int mid = start + ((end - start)/2);
	
	        if (start < mid && words[mid].compareTo(words[mid - 1]) < 0) {
	            return mid;
	        }
	        
	        else if (end > mid && words[mid].compareTo(words[mid + 1]) > 0) {
	            return mid + 1;
	        }
	        
	        else if (words[mid].compareTo(words[start]) > 0 && 
	                words[mid].compareTo(words[end]) > 0) {
	            return findRotationPoint(words, mid + 1, end);
	        }
	        else {
	            return findRotationPoint(words, start, mid - 1);
	        }
	    }
}
