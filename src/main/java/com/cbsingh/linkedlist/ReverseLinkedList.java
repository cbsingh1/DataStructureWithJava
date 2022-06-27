package com.cbsingh.linkedlist;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null, nextNode;
        while (head != null) {
            nextNode = head.next;
            head.next = prev;
            prev = head;
            head =nextNode;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return String.valueOf(val);
        }

        void printList(ListNode node) {
            while (node != null) {
                System.out.print(node.val + "->");
                node = node.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        listNode.printList(listNode);
        listNode.printList(reverseList(listNode));
    }
}
