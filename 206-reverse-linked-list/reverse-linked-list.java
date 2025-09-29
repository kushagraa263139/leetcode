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
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode last=null;
        while(head.next!=null){
            ListNode n = head.next;
            head.next=last;
            last=head;
            head=n;
        }
        head.next=last;
        return head;
    }
}