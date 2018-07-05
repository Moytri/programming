package sorting;
import java.util.LinkedList;
import java.util.ListIterator;

class SelectionSortOfList {

        public static Node head = null;
        public static Node tail = null;
	private int size = 0;
	public static void main(String [] args){

		SelectionSortOfList ls = new SelectionSortOfList();
		ls.add(4);
		ls.add(10);
		ls.add(3);
		ls.add(5);
		ls.add(7);
		ls.add(2);

		ls.print();
                ls = selectionSort(ls);
                ls.print();
	}

	public static SelectionSortOfList selectionSort(SelectionSortOfList ls) {
	
		Node min = null, temp = null;

		for(Node init = head; init != null; init = init.next) {
			min = init;
			for(Node nextInit = init; nextInit != null; nextInit = nextInit.next) {
				if(min.data > nextInit.data) {		
					min = nextInit;
				}
			}
			if(init != min) {
				temp = new Node(init.data);
				init.data = min.data;
				min.data = temp.data;
			}
		}
		return ls;	
	}

	public boolean isEmpty() {
		if(size == 0){
			return true;
		}
		return false;
	}

	public void add(int data){
		Node newNode = new Node(data);
		if(isEmpty()){
		    head = newNode;
		}
		else{
		    newNode.next = head;
		    head = newNode;
		}
		size++;
	}

	public void print() {
		Node node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	static class Node {
		int data;
		Node next;

		Node(int data){
			this.data = data;
			this.next = null;
		}
	
	        public void setData(int data) {
			this.data = data;
		}	
		
		public int getData() {
			return data;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		public Node getNext() {
			return next;
		}
        }
}
