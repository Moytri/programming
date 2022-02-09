package heap.general;

public class HeapSort {

	public static void main(String[] args) {
		HeapSort heapSort = new HeapSort();
		int [] arr = {2,4,6,8,10,11,16};
		heapSort.buildMaxHeap(arr);
		heapSort.heapSort(arr);
	}
	
    public void heapSort(int [] nums) {
        int length = nums.length;
        for (int i = length - 1; i >= 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            
            heapify(nums, i, 0);
        }
    }
    
	public void buildMaxHeap(int [] nums) {
		int length = nums.length;
		int start = length/2 - 1;
		
		for (int i = start; i >=0; i--) {
			heapify(nums, length, i);
		}
	}
	
	public void heapify(int [] nums, int size, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right= 2 * i + 2;
		
		if (left < size && nums[left] > nums[largest]) {
			largest = left;
		}
		
		if (right < size && nums[right] > nums[largest]) {
			largest = right;
		}
		
		if (largest != i) {
			swap(nums, i, largest);
			heapify(nums, size, largest);
		}
	}
	
	public void swap(int [] nums, int x, int z) {
		int temp = nums[x];
		nums[x] = nums[z];
		nums[z] = temp;
	}

}
