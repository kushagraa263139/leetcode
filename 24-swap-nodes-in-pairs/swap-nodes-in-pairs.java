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
    public ListNode swapPairs(ListNode head) {

        if(head==null) return null;

        ListNode s=head;

        
        ListNode temp=s;
        ListNode e=head.next;
        int c=1;

        while(e!=null)
        {
            s.next=e.next;
            e.next=s;
            if(c!=1)
            {
            temp.next=e;

            }

            if(c==1)
            {
                head=e;
                c++;
            }
            temp=s;
            s=s.next;
            
            if(s==null) return head;
            e=e.next.next.next;
        }
        return head;
    }
}
