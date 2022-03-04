package com.cbsingh.linkedlist;

public class DoublyLinkedList {

    static class Node {
        int value;
        Node next, prev;

        Node(int val) {
            value = val;
        }
    }

    Node head, tail = null;
    int size;


    public void add(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.prev = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            tail.next = null;
        }
        size++;
    }

    public boolean addBefore(int data, int positionValue) {

        if (head == null) {
            return false;
        }
        Node currentNode = head;
        Node newNode = new Node(data);
        while (currentNode != null) {

            if (currentNode.value == positionValue) {

                newNode.prev = currentNode.prev;
                newNode.next = currentNode;
                currentNode.prev = newNode;

                if(currentNode == head) {
                    head = newNode;
                } else {
                    currentNode.prev.next=newNode;
                }
                size++;
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    public void print() {
        Node currentNode = head;

        while (currentNode != null) {
            System.out.print(currentNode.value + " <-> ");

            currentNode = currentNode.next;
        }
        System.out.print("null \n");
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.add(10);
        doublyLinkedList.add(20);
        doublyLinkedList.add(30);
        doublyLinkedList.print();

        doublyLinkedList.addBefore(5, 10);
        doublyLinkedList.print();
    }
}
