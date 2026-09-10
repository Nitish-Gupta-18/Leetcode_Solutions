class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int len = 0;
        ListNode temp = head;

        // Step 1: find length
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // Step 2: if we need to delete head
        if (len == n) {
            return head.next;
        }

        // Step 3: go to (len - n - 1)th node
        temp = head;
        for (int i = 0; i < len - n - 1; i++) {
            temp = temp.next;
        }

        // Step 4: delete node
        temp.next = temp.next.next;

        return head;
    }
}