package recursion;

import recursion.SinglyLinkedList.Node;

public class RemoveLinkedListElement {

	public static void main(String[] args) {
		SinglyLinkedList.add(1);
		SinglyLinkedList.add(2);
		SinglyLinkedList.add(6);
		SinglyLinkedList.add(3);
		SinglyLinkedList.add(4);
		SinglyLinkedList.add(5);
		SinglyLinkedList.add(6);
		
		RemoveLinkedListElement elem = new RemoveLinkedListElement();
		elem.removeElements(SinglyLinkedList.head, 6);

	}
	
	 public Node removeElements(Node head, int val) {
	     if (head == null) return null;
	     if (head.val == val) return removeElements(head.next, val);
	     else {
	    	 head.next = removeElements(head.next, val);
	    	 return head;
	     }
	 }

}
