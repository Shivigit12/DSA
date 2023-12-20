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
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> dups = new HashSet<>();
        ListNode temp = head;
        while(temp != null) {
            if(!set.contains(temp.val)) {
                set.add(temp.val);
            } else
                dups.add(temp.val);
            temp = temp.next;
        }
        
        ListNode newNode = new ListNode(-1);
        ListNode newHead = newNode;
        temp = head;
        
        while(temp != null) {
            if(!dups.contains(temp.val)) {
                newNode.next = temp;
                newNode = newNode.next;
            }
            temp = temp.next;
        }
        newNode.next = null;
        return newHead.next;
    }
}