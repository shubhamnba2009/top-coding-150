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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> q = new PriorityQueue<>();

        for(ListNode l:lists){
            ListNode tr = l;
            while(tr!=null)  {
                q.add(tr.val);
                tr=tr.next;
                }
        }

        ListNode tmp = new ListNode(-1);
        ListNode dummy = tmp;

        while(!q.isEmpty()){
            tmp.next = new ListNode(q.poll());
            tmp = tmp.next;
        }
        return dummy.next;
    }
}