package com.codecool.dataStructures;

import com.codecool.dataStructures.exceptions.EmptyQueueException;

public class GenericQueue <T> {
    class Node {
        private T value;
        private Node next;
        private Integer prioryty;

        Node(T value) {
            this.value = value;
        }

        Node(T value, Integer prioryty) {
            this.value = value;
            this.prioryty = prioryty;
        }

        public T getValue() {
            return this.value;
        }

        public Node next() {
            return this.next;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public void enqueue(T element) {
        Node newNode = new Node(element);

        if(size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    public T dequeue() throws EmptyQueueException {
        if(this.size < 1) {
            throw new EmptyQueueException("Queue is empty");
        }

        Node removedNode = this.head;
        this.head = this.head.next();

        this.size--;

        return removedNode.getValue();
    }

    public T peek() {
        return this.head.getValue();
    }

    public int size() {
        return this.size;
    }
}
