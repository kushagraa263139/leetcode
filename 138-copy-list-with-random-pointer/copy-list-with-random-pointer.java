/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head==null) return null;

        Node temp=new Node(-1);
        Node a=temp;
        Node h=head;

        while(h!=null)
        {
            Node b=new Node(h.val);
            a.next=b;
            h=h.next;
            a=a.next;
        }
        temp=temp.next;

        Node b=temp;
        a=head;

        while(a!=null)
        {
            Node x=a.next;
            Node y=b.next;
            a.next=b;
            b.next=x;
            a=x;
            b=y;
        }

         a=head;
        b=head.next;

        while(b.next!=null)
        {
            if(a.random == null)
            {
                b.random=null;
            }
            else
            {
            b.random=a.random.next;

            }
            a=a.next.next;
            b=b.next.next;
        }
        if(a.random==null)
        {
            b.random=null;
        }
        else 
        {
        b.random=a.random.next;

        }

        a=head;
         b=head.next;

        while(b.next!=null)
        {
            a.next=b.next;
            b.next=a.next.next;
            a=a.next;
            b=b.next;

        }
        a.next=null;
        return temp;
        
    }
}