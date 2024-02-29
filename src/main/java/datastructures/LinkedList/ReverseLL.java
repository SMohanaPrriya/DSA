package datastructures.LinkedList;

//Leetcode practice.
public class ReverseLL {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
        public ListNode reverseList(ListNode head) {
            if( head == null || head.next == null) {
                return head;
            }
            ListNode current = head;
            ListNode prev = null;
            ListNode next;
            while(current!=null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }

}
