class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null)
            return null;

        int count = 0;
        ListNode temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        int middle = count / 2;

        temp = head;
        for(int i = 1; i < middle; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}