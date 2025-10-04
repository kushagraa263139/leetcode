/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1=0;
        int size2=0;
        ListNode c = headA;
        while(c!=null){
            size1++;
            c=c.next;
        }
        c=headB;
        while(c!=null){
            c=c.next;
            size2++;
        }
        ListNode fast=headA;
        ListNode slow=headB;
        int d = Math.abs(size1-size2);
        if(size2>size1){
            fast=headB;
            slow=headA;
        }
      
        while(d>0){
            fast=fast.next;
            d--;
        }

        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
            if(slow==null || fast==null) return null;
        }

        return fast;

    }
}