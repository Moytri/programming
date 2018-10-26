package cciLinkedList;

/*Delete Middle Node: Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
lnput:the node c from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a ->b->d- >e- >f*/

import cciLinkedList.SinglyLinkedList.Node;

public class RemoveMidNode {

	public static void main(String[] args) {
		SinglyLinkedList.add(4);
		SinglyLinkedList.add(5);
		SinglyLinkedList.add(3);
		SinglyLinkedList.add(6);
		SinglyLinkedList.add(1);
		
		System.out.println("The original List : ");
		SinglyLinkedList.print(SinglyLinkedList.head);
		
		removeMid(SinglyLinkedList.head);
		
		System.out.println("After removal : ");
		SinglyLinkedList.print(SinglyLinkedList.head);
	}
	
	public static void removeMid(Node head) {
		Node curr = head;
		Node prev = head;
		Node mid = head;
		int count = 0;
		if(curr.next == null) head = null;
		else {
			while(curr != null) {
				count++;
				if(count > 2 && count%2 == 0) {
					prev = mid;
					mid = mid.next;
				}
				curr = curr.next;
			}
			if(count!=1 && count%2 == 1){
				prev = mid;
				mid = mid.next;
			}
			if(count == 2) {
				SinglyLinkedList.head = mid.next;
			}
			else {
				prev.next = mid.next;
			}
		}
	}

}
