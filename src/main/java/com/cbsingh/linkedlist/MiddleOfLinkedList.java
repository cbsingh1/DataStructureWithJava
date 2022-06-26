package com.cbsingh.linkedlist;

//Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

public class MiddleOfLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode nextNode=head.next;
        while (head != null && nextNode != null) {
            head = head.next;
            if(nextNode.next != null)
                nextNode = nextNode.next.next;
            else
                break;

        }
        return head;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode listNode2 = new ListNode(1);
        listNode.printList(listNode);
        listNode.printList(middleNode(listNode));
        listNode.printList(listNode1);
        listNode.printList(middleNode(listNode1));
        listNode.printList(listNode2);
        listNode.printList(middleNode(listNode2));

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
}
