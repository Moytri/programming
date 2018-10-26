package cciLinkedList;

/* Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/

import java.util.HashSet;
import java.util.Set;

import cciLinkedList.SinglyLinkedList.Node;

public class RemoveDuplicate {

	public static void main(String[] args) {
		SinglyLinkedList.add(4);
		SinglyLinkedList.add(4);
		SinglyLinkedList.add(3);
		SinglyLinkedList.add(4);
		SinglyLinkedList.add(1);
		
		System.out.println("The original List : ");
		SinglyLinkedList.print(SinglyLinkedList.head);
		
		removeDups(SinglyLinkedList.head);
		System.out.println("Remove duplicates : ");
		SinglyLinkedList.print(SinglyLinkedList.head);
		
		System.out.println("Revome Duplicates using set : ");
		SinglyLinkedList.print(SinglyLinkedList.head);
	}

	//using two pointers, TC - O(n^2), SC - O(1)
	public static void  removeDups(Node head) {
		while(head != null) {			
			Node curr = head.next;
			Node prev = head;
			
			while(curr != null) {
				if(head.val != curr.val) {
					prev = prev.next;
				}
				else {
					prev.next = curr.next;
				}
				curr = curr.next;
			}
			head = head.next;
		}
	}
	
	//using external space, TC - O(N), SC - O(1)
	public static void removeDuplicates(Node head) {
		Set<Node> set = new HashSet<>();
		Node prev = head;
		while(head != null) {
			if(set.contains(head.val)) {
				prev.next = head.next;
			}
			else {
				set.add(head);
				prev = head.next;
			}
			head = head.next;
		}
	}
	
}