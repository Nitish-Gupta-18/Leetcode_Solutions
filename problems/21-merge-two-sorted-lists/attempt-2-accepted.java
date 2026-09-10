class Solution {
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0); // dummy node
        ListNode temp = head;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }

        // add remaining nodes
        if (a != null) {
            temp.next = a;
        } else {
            temp.next = b;
        }

        return head.next;
    }
}