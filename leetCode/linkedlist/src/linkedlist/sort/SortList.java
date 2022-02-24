package linkedlist.sort;

/**
 * 
 * @author Moytri
 * Problem: https://leetcode.com/problems/sort-list/
 *
 */
public class SortList {

	public static void main(String[] args) {

	}
	 public ListNode sortList(ListNode head) {
	        if (head == null || head.next == null) return head;
	        
	        ListNode mid = getMid(head);
	        ListNode left = sortList(head);
	        ListNode right = sortList(mid);
	        
	        return merge(left, right);
	    }
	    
	    private ListNode merge(ListNode head1, ListNode head2) {
	        ListNode dummyHead = new ListNode();
	        ListNode tail = dummyHead;
	        
	        while (head1 != null && head2 != null) {
	            if (head1.val < head2.val) {
	                tail.next = head1;
	                head1 = head1.next;
	            }
	            else {
	                tail.next = head2;
	                head2 = head2.next;
	            }
	            tail = tail.next;
	        }
	        
	        tail.next = head1!= null ? head1 : head2;
	        return dummyHead.next;
	    }
	    
	    ListNode getMid(ListNode head) {
	        ListNode midPrev = null;
	        while (head != null && head.next != null) {
	            midPrev = (midPrev == null) ? head : midPrev.next;
	            head = head.next.next;
	        }
	        ListNode mid = midPrev.next;
	        midPrev.next = null;
	        return mid;
	    }	

}
