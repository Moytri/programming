package recursion;

public class SinglyLinkedList {
	private static int size = 0;
	protected static Node head = null;
	public static void main(String[] args) {
		add(2);
		add(4);
		add(1);
		print(head);
	}
	
	public int size() {
		return size;
	}
	
	public static void add(int data) {
		Node newNode = new Node(data);
		if(head == null) head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
		size++;
	}
	
	public static void print(Node head) {
		while(head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
	
	static class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
