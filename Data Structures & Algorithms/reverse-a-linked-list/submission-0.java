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
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        var list = new ArrayList<Integer>();
        while (head != null) {
            list.add(0, head.val);
            head = head.next;
        }
        System.out.println(list);
        ListNode newHead = new ListNode(list.get(0));
        var cur = newHead;
        for (int i = 1; i < list.size(); i++) {
            ListNode temp = new ListNode(list.get(i));
            cur.next = temp;
            cur = temp;
        }

        return newHead;
        
    }
}
