package com.cbsingh.queue;

import java.util.NoSuchElementException;

public class QueueWithArrayImpl {
    private int[] queue;
    private int front;
    private int back;

    public QueueWithArrayImpl(int capacity) {
        queue = new int[capacity];
    }

    public void add(int item) {
        if (back == queue.length) {
            int[] newArray = new int[2 * queue.length];
            System.arraycopy(queue, 0, newArray, 0, queue.length);
            queue = newArray;
        }
        queue[back++] = item;
    }

    public int remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        int returnValue = queue[front++];
        if (size() == 0) {
            front = 0;
            back = 0;
        }
        return returnValue;
    }

    public int size() {
        return back - front;
    }

    public int peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {

        CircularQueueWithArrayImpl arrayQueue = new CircularQueueWithArrayImpl(5);

        arrayQueue.add(3);
        arrayQueue.add(2);
        arrayQueue.add(4);
        arrayQueue.printQueue();
        System.out.println(arrayQueue.remove());
        arrayQueue.printQueue();

    }
}

