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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        } else if(list1==null ){
            return list2;
        } else if(list2==null){
            return list1;
        }
        ListNode l1 = new ListNode();
        ListNode i = list1;
        ListNode j = list2;
        if(i.val<=j.val){
            l1.val=i.val;
            i=i.next;
        } else {
            l1.val = j.val;
            j=j.next;
        }
        ListNode p = l1;
        while(i!=null || j!=null){
            if(i==null){
                ListNode nxt = new ListNode(j.val);
                p.next=nxt;
                p = p.next;
                j=j.next;
                continue;
            }
            if(j==null){
                ListNode nxt = new ListNode(i.val);
                p.next=nxt;
                p = p.next;
                i=i.next;
                continue;
            }
            if(i.val<=j.val){
                ListNode nxt = new ListNode(i.val);
                p.next=nxt;
                p = p.next;
                i=i.next;
                continue;
            } else {
                ListNode nxt = new ListNode(j.val);
                p.next=nxt;
                p = p.next;
                j=j.next;
                continue;
            }
        }
        return l1;
    }
}