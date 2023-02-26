package com.cbsingh.leetcode;



public class LeetCode92_ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printList(reverseBetween(head, 2,4));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        //base case
        if(head.next == null) return head;
        if(left == right) return head;

        //define pre and cur
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        //Move pre and cur into the right position
        for(int i = 1; i < left; i++){
            pre = cur;
            cur = cur.next;
        }
        //reverse the sublist
        int connections = right - left;
        ListNode nex;
        for(int i = 0; i < connections; i++){
            nex = cur.next;
            cur.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }

        //return head node
        return dummy.next;
    }
}
