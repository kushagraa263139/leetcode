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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode s =l1;
        ListNode e=l2;
        ListNode ans = new ListNode(-1);
        ListNode temp=ans;
        int carry=0;

        while(s!=null && e!=null)
        {
            int sum = s.val + e.val + carry;
            if(sum>9)
            {
                ListNode help = new ListNode(sum%10);
                temp.next=help;
                temp=temp.next;
                carry=1;
            }
            else
            {
                ListNode help = new ListNode(sum);
                temp.next=help;
                temp=temp.next;
                carry=0;
            }
            s=s.next;
            e=e.next;

      
        }

        while(s!=null)
        {
            int sum = s.val + carry;
             if(sum>9)
            {
                ListNode help = new ListNode(sum%10);
                temp.next=help;
                temp=temp.next;
                carry=1;
            }
            else
            {
                ListNode help = new ListNode(sum);
                temp.next=help;
                temp=temp.next;
                carry=0;
            }
            s=s.next;
        }
         while(e!=null)
        {
            int sum = e.val + carry;
             if(sum>9)
            {
                ListNode help = new ListNode(sum%10);
                temp.next=help;
                temp=temp.next;
                carry=1;
            }
            else
            {
                ListNode help = new ListNode(sum);
                temp.next=help;
                temp=temp.next;
                carry=0;
            }
            e=e.next;
        }
        if(carry==1)
        {
                ListNode help = new ListNode(1);
                temp.next=help;
                temp=temp.next;

        }

        return ans.next;
        
        
    }
}