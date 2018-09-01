Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?

https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Very Very Interesting Solution in Java in one pass:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {       
        Stack<ListNode> stack = new Stack<>();                  
        ListNode prev = null;
        ListNode next = null; 
        
        while(head != null) {
            stack.push(head); //push to stack         
            int count = 0;
            
            //if it reaches at end then pop
            if(head.next == null) {
                while(!stack.empty()) {
                    if(count != n - 1) { 
                        prev = stack.pop();
                        prev.next = next;
                        next = prev;
                    }
                    else {
                       stack.pop(); //if number of poped item 						equals n-1 just pop it for deleting
                    }
                    count++;
                }
            }
            head = head.next;
        }
        return next;
    }
}