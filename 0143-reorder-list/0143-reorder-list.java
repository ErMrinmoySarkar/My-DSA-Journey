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
    private ListNode getMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;

        ListNode mid = getMid(head);
        //reverse half part
        ListNode curr = mid.next, prev = null, next;
        mid.next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode st = head, end = prev;
        ListNode newStart, newEnd;
        while(st != null && end != null){
            newStart = st.next;
            st.next = end;

            newEnd = end.next;
            end.next = newStart;
            end = end.next;

            st = newStart;
            end = newEnd;
        }

        return;

    }
}