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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = null;
        ListNode temp = head;
        ListNode temp1 = head;
        int count = 1;
        while(temp.next != null) {
            count++;
            temp = temp.next;
        }
        System.out.println(count);
        temp.next = head;
        k = k % count;
        for(int i = 1; i < count - k; i++) {
            temp1 = temp1.next;
        }
        newHead = temp1.next;
        temp1.next = null;
        return newHead;
    }
}