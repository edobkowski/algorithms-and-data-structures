package com.codecool.dataStructures;

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
    private int size;

    public void enqueue(T element) {

    }

    public T dequeue() {
        return null;
    }

    public T peek() {
        return null;
    }

    public int size() {
        return this.size;
    }

    public T getHead() {
        return head.getValue();
    }

    public T getTail() {
        return tail.getValue();
    }
}
