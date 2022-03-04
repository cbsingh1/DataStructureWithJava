package com.cbsingh.linkedlist;

public class LinkedListImpl {
    static class Node {
        int element;
        Node next;

        Node(int e) {
            element = e;
            next = null;
        }
    }

    Node head;
    int size;

    public void addFirst(int e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int e) {
        Node newNode = new Node(e);
        if(head == null) {
            head = newNode;
        } else {
            Node currentNode = head;
            while(currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

        size++;
    }

    public void print() {
        Node currentNode = head;

        while(currentNode != null) {
            System.out.print(currentNode.element + " -> ");

            currentNode = currentNode.next;
        }
        System.out.print("null \n");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }


    public static void main(String[] args) {

        LinkedListImpl linkedList = new LinkedListImpl();

        linkedList.addLast(10);
        linkedList.print();
        linkedList.addLast(20);
        linkedList.print();
        linkedList.addFirst(5);
        linkedList.print();
    }

}
