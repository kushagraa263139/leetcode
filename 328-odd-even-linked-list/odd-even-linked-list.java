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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp=head;
        ListNode odd = new ListNode(-1);
        
        ListNode even = new ListNode (-1);
        ListNode curr=odd;
        ListNode curr2=even;
        while(temp!=null){
            curr.next=temp;
            curr=curr.next;
            curr2.next=temp.next;
            curr2=curr2.next;
            if(temp.next==null) break;
            temp=temp.next.next;
        }
        curr.next=even.next;
        return odd.next;
    }
}