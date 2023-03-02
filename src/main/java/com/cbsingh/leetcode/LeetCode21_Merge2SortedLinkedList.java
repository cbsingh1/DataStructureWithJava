package com.cbsingh.leetcode;

import com.cbsingh.linkedlist.MiddleOfLinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}

public class LeetCode21_Merge2SortedLinkedList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val < list2.val) {
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

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list2 = new ListNode(1, new ListNode(3));

        ListNode mergedList = mergeTwoLists(list1, list2);

        while (mergedList != null) {
            System.out.print(mergedList.val + "->");
            mergedList = mergedList.next;
        }
    }
}


