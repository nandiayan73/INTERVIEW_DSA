//   Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class deleteNode {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp=head;
        if(temp==null)
            return null;
        ListNode pre=head;
        while(temp!=null)
        {
            if(temp.val==val)
            {
                pre.next=temp.next;
            }
            else
            {
                pre=temp;
            }
            temp=temp.next;
        }
        if(head.val==val)
            return head.next;
        return head;

    }
}