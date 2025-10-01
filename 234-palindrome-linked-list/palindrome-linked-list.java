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
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp=head;
        // reverse the connections till size/2;
        int s = size/2;
        ListNode head1=null;
        while(s>0){
            ListNode x = temp;
            temp=temp.next;
            x.next=head1;
            head1=x;
            s--;
        }
        if(size%2!=0) temp=temp.next;
        while(temp!=null){
            if(temp.val!=head1.val) return false;
            temp=temp.next;
            head1=head1.next;
        }
        return true;

        
    }
}