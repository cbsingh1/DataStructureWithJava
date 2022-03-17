package com.cbsingh.queue;

import java.util.NoSuchElementException;

public class CircularQueueWithArrayImpl {
    private int[] queue;
    private int front;
    private int back;

    public CircularQueueWithArrayImpl(int capacity) {
        queue = new int[capacity];
    }

    public void add(int item) {
        if (size() == queue.length - 1) {
            int[] newArray = new int[2 * queue.length];
            if (front <= back) {
                System.arraycopy(queue, 0, newArray, 0, queue.length);
            } else {
                System.arraycopy(queue, front, newArray, 0, queue.length - front);
                if (back > 0) {
                    System.arraycopy(queue, 0, newArray, queue.length - front, back);
                }

                back = size();
                front = 0;
            }

            queue = newArray;
        }
        queue[back] = item;

        //Here, if back is equal to last element of array, then
        //back would be started with position 0, if there is null element at front
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }
    }

    public int remove() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }

        int returnValue = queue[front];
        queue[front++] = -1;

        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }
        return returnValue;
    }

    public int size() {
        if (front <= back)
            return back - front;
        else {
            return (queue.length - front) + (back);
        }

    }

    public int peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public void printQueue() {

        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.print("\n");
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int j = 0; j < back; j++) {
                System.out.print(queue[j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {

        CircularQueueWithArrayImpl arrayQueue = new CircularQueueWithArrayImpl(3);

        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.remove();
        arrayQueue.add(3);
        arrayQueue.printQueue();
        arrayQueue.remove();
        arrayQueue.printQueue();
        arrayQueue.add(4);
        arrayQueue.printQueue();

    }
}

