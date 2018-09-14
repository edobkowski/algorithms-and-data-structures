package com.codecool.dataStructures;

import com.codecool.dataStructures.exceptions.EmptyQueueException;

public class GenericQueue <T> {
    class Node {
        private T value;
        private Node next;
        private Integer prioryty = -1;

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

        public Integer getPrioryty() {
            return prioryty;
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
        enqueue(element, -1);
    }

    public void enqueue(T element, Integer priority) {
        Node newNode = new Node(element, priority);

        if(size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            insertNode(newNode);
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

    public boolean isEmpty() {
        return this.head == null;
    }

    private void insertNode(Node node) {
        Node currentNode = this.head;

        if(currentNode.getPrioryty() < node.getPrioryty()) {
            node.setNext(currentNode);
            this.head = node;
        } else {
            Node nextNode = currentNode.next();
            while (nextNode != null && nextNode.getPrioryty() >= node.getPrioryty()) {
                currentNode = currentNode.next();
                nextNode = nextNode.next();
            }
            currentNode.setNext(node);
            node.setNext(nextNode);

            if(nextNode == null) {
                this.tail = node;
            }
        }
    }
}
