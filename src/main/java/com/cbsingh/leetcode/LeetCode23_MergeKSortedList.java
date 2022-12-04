package com.cbsingh.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode23_MergeKSortedList {
    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        if(lists.length==1) return lists[0];
        Queue<ListNode> queue = new LinkedList<>();
        for(ListNode node : lists)
            queue.add(node);

        while(queue.size() > 1) {
            ListNode merged = mergeTwoList(queue.remove(), queue.remove());
            queue.add(merged);
        }
        return queue.peek();
    }

    static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail =tail.next;
        }
        tail.next = list1==null ? list2 : list1;
        return dummy.next;
    }
}
