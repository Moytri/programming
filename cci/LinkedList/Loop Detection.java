/**
 * 2.8: Loop Detection
 * Given a circular linked list, implement an algorithm that returns the node at
 * the beginning of the loop.
 */

package cciLinkedList;

import cciLinkedList.SinglyLinkedList.Node;

public class LoopDetection {

	public static void main(String[] args) {
		SinglyLinkedList.add(4);
		SinglyLinkedList.add(5);
		SinglyLinkedList.add(3);
		SinglyLinkedList.add(6);
		SinglyLinkedList.add(4);
		SinglyLinkedList.add(7);
		SinglyLinkedList.add(8);
		SinglyLinkedList.add(9);
		
		System.out.println("The original List : ");
		SinglyLinkedList.print(SinglyLinkedList.head);
		
		System.out.println("Has Loop: ");
		System.out.println(hasLoop(SinglyLinkedList.head));
	}
	
	public static boolean hasLoop(Node head) {
		Node fast = head.next;
		Node slow = head;
		if(head == null) return false;
		while(fast != null && fast.next != null && slow!= null) {
			if(fast == slow) return true;
			fast = fast.next.next;
			slow = slow.next;
		}
		return false;
	}

}
