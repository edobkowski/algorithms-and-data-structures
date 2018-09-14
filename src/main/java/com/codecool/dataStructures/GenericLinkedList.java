package com.codecool.dataStructures;

public class GenericLinkedList <T> {
    private class Node <T> {
        private T content;
        private Node next;

        Node(T content) {
            this.content = content;
        }

        public Node next() {
            return this.next;
        }

        public T getContent() {
            return this.content;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public GenericLinkedList() {
    }

    public void add(T element) {
        Node newNode = new Node(element);

        if(this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    public void remove(int index) {
        checkExceptions(index);

        if(this.head == this.tail) {
            tail = null;
        }

        if(index == 0) {
            this.head = this.head.next();
        } else {
            Node precedingNode = findPrecedingNode(index);
            precedingNode.setNext(precedingNode.next().next());

            if(precedingNode.next() == null) {
                this.tail = precedingNode;
            }
        }

        size--;
    }

    public void insert(int index, T element) {
        checkExceptions(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = head;

        while(currentNode != null) {
            sb.append(currentNode.getContent()).append(" ");
            currentNode = currentNode.next();
        }

        return sb.toString().trim();
    }

    private Node findPrecedingNode(int index) {
        int nodeIndex = 0;
        Node currentNode = this.head;

        while(nodeIndex+1 != index) {
            currentNode = currentNode.next();
            nodeIndex++;
        }

        return currentNode;
    }

    private void checkExceptions(int index) {
        if(index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
