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
        ListNode res = new ListNode(0);
        ListNode head = res;
        while(l1 != null || l2 != null) {
            int sum = 0;
            if(l1 == null) {
                sum = l2.val + res.val;
                l2 = l2.next;
            }else if(l2 == null) {
                sum = l1.val + res.val;
                l1 = l1.next;
            }else{
                sum = l1.val + l2.val + res.val;
                l1 = l1.next;
                l2 = l2.next;
                
            }
            if(sum >= 10) {
                sum = sum - 10;
                res.val = sum;
                res.next = new ListNode(1);
            }else{
                res.val = sum;
                if(l1 != null || l2 != null)
                    res.next = new ListNode(0);
            }
            res = res.next;
                
        }
        return head;
    }
}