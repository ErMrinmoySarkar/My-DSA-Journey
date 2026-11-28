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
class Solution {
    public ListNode findMid(ListNode head){
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!=null){
            slow = slow.next; //+1;
            fast = fast.next.next; //+2
        }
        return slow;
    }
    public boolean isPalindrome(ListNode head) {

        ListNode prev = null, curr = findMid(head), next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }
        ListNode st = head, end = prev;
        while(end!=null){
            if(st.val != end.val) return false;
            st = st.next;
            end = end.next;
        } 
        return true;
    }
}