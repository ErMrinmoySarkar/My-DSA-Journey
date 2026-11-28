/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next == null) return null;
        ListNode slow = head, fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                isCycle = true;
                slow = head;
                break;
            }
        }

        if(!isCycle) return null;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }
}