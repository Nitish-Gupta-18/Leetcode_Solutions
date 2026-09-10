class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode temp = dummy;

        // move temp n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            temp = temp.next;
        }

        // move both until temp reaches null
        while (temp != null) {
            prev = prev.next;
            temp = temp.next;
        }

        // delete node
        prev.next = prev.next.next;

        return dummy.next;
    }
}