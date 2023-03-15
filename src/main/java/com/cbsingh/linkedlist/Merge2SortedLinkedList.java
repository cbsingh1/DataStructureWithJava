package com.cbsingh.linkedlist;

public class Merge2SortedLinkedList {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(list1, list2);

        result.printList(result);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode(), current = list1, other = list2;
        ListNode head = mergedList;

        while (current != null && other != null) {
            if (current.val <= other.val) {
                mergedList.next = new ListNode(current.val);
                current = current.next;
            } else {
                mergedList.next = new ListNode(other.val);
                ListNode temp = current;
                current = other.next;
                other = temp;
            }
            mergedList = mergedList.next;
        }

        while (current != null) {
            mergedList.next = new ListNode(current.val);
            current = current.next;
            mergedList = mergedList.next;
        }

        while (other != null) {
            mergedList.next = new ListNode(other.val);
            other = other.next;
            mergedList = mergedList.next;
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("null");
    }
}

