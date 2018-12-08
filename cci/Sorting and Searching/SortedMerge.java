package ccisortingsearching;

/*Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
end to hold B. Write a method to merge B into A in sorted order.*/

public class SortedMerge {

	public static void main(String[] args) {
		int [] a = new int[15];
		for(int i = 0; i <= 5; i++) {
			a[i] = i + 2;
		}
		int [] b = {2,10,11};
		a = new SortedMerge().sortedMerger(a,b,5);
		int mergedIndex = 5 + b.length;
		
		for(int i = 0; i <= mergedIndex; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public int [] sortedMerger(int [] a, int [] b, int last) {
		int i = last;
		int j = b.length - 1;
		int mergedIndex = last + b.length;
		
		while(j >= 0) {
			if(i >= 0 && a[i] >= b[j]) {
				a[mergedIndex] = a[i--];
			}
			else {
				a[mergedIndex] = b[j--];
			}
			mergedIndex--;
		}
		
		return a;
	}

}
