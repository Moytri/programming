You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

My Solution:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode tail = null;
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        
        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            head = add(sum % 10,head);
            carry = sum/10;
            l2 = l2.next;
            l1 = l1.next;
        }
        
        while(l1 != null) {
            int sum = l1.val + carry;
            head = add(sum % 10,head);
            carry = sum/10;
            l1 = l1.next;
        }
        
        while(l2 != null) {
            int sum = l2.val + carry;
            head = add(sum % 10,head);
            carry = sum/10;
            l2 = l2.next;
        }
        
        if(carry == 1) {
            head = add(carry,head);
        }
        return head;
        
    }
    
    public ListNode add(int data,ListNode head){
		ListNode newNode = new ListNode(data);
		if(head == null){
			tail = newNode;
            System.out.println(tail.val);
			head = tail;
		}
		else{
			tail.next = newNode;
			newNode.next = null;
			tail = newNode;
            System.out.println(tail.val);
		}
		return head;
	}
}