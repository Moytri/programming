package heap.min;

public class MinHeap {
    int [] minHeap;
    int heapSize;
    int realSize = 0;
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(6);
		minHeap.insert(4);
		System.out.println(minHeap.toString());
		minHeap.insert(1);
		System.out.println(minHeap.toString());
		minHeap.insert(6);
		minHeap.insert(5);
		System.out.println(minHeap.toString());
		minHeap.delete();
		System.out.println(minHeap.toString());
	}
	
	public MinHeap(int heapSize) {
		this.heapSize = heapSize;
		this.minHeap = new int[heapSize];
		minHeap[0] = 0;
	}
	
	public void insert(int val) {
		realSize++;
		
		if (realSize > heapSize) {
			System.out.println("Overflow");
			realSize--;
			return;
		}
		
		int index = realSize;
		minHeap[index] = val;
		int parent = index/2;
		
		while (minHeap[index] < minHeap[parent] && index > 1) {
			int temp = minHeap[index];
			minHeap[index] = minHeap[parent];
			minHeap[parent] = temp;
			index = parent;
			parent = index / 2;
		}
	}
	
	public int delete() {
        if (realSize < 1) {
            System.out.println("Don't have any element!");
            return Integer.MAX_VALUE;
        }
        
		int removedItem = minHeap[1];		
		minHeap[1] = minHeap[realSize];
		realSize--;
		
		int index = 1;
		
		while (index <= realSize / 2) {
			int left = index * 2;
			int right = index * 2 + 1;
			
			if (minHeap[index] > minHeap[left] || minHeap[index] > minHeap[right]) {
				if (minHeap[left] < minHeap[right]) {
					int temp = minHeap[index];
					minHeap[index] = minHeap[left];
					minHeap[left] = temp;
					index = left;
				}
				else {
					int temp = minHeap[index];
					minHeap[index] = minHeap[right];
					minHeap[right] = temp;
					index = right;					
				}
			}
		}
		
		return removedItem;
	}
	
	// return the number of elements in the Heap
    public int size() {
        return realSize;
    }

    public String toString() {
        if (realSize == 0) {
            return "No element!";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 1; i <= realSize; i++) {
                sb.append(minHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append(']');
            return sb.toString();
        }
    }

}
