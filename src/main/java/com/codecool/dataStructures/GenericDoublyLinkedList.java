package com.codecool.dataStructures;

@SuppressWarnings("unchecked")
public class GenericDoublyLinkedList <T> {
    class Node <T> {
        private T content;
        private Node next;
        private Node previous;

        Node(T content) {
            this.content = content;
        }

        public Node next() {
            return this.next;
        }

        public Node previous() {
            return this.previous;
        }

        public T getContent() {
            return this.content;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        @Override
        public String toString() {
            return content.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size = 0;

    public Node head() {
        return this.head;
    }

    public Node tail() {
        return this.tail;
    }

    public void add(T element) {
        Node newNode = new Node(element);

        if(this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrevious(this.tail);
            this.tail = newNode;
        }

        this.size++;
    }

    public void remove(int index) {
        checkExceptions(index);

        if(index == 0) {
            this.head = this.head.next();
        } else {
            Node removedNode = findNode(index);
            popNode(removedNode);
        }

        setTail();
        this.size--;
    }

    public void insert(int index, T element) {
        checkExceptions(index);
        Node newNode = new Node(element);

        if(index == 0) {
            newNode.setNext(this.head);
            this.head = newNode;
        } else {
            Node previousNode = findNode(index).previous();
            Node nextNode = previousNode.next();

            newNode.setNext(nextNode);
            newNode.setPrevious(previousNode);
            previousNode.setNext(newNode);
            nextNode.setPrevious(newNode);
        }

        this.size++;
    }

    public Node get(int index) {
        checkExceptions(index);

        return findNode(index);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node currentNode = this.head;

        while(currentNode != null) {
            sb.append(currentNode.getContent()).append(" ");
            currentNode = currentNode.next();
        }

        return sb.toString().trim();
    }

    private void popNode(Node node){
        Node precedingNode = node.previous();
        Node nextNode = node.next();

        precedingNode.setNext(nextNode);
        nextNode.setPrevious(precedingNode);
    }

    private void setTail() {
        if(this.head == null) {
            this.tail = null;
            return;
        }

        Node currentNode = this.head;

        while(currentNode.next() != null) {
            currentNode = currentNode.next();
        }

        this.tail = currentNode;
    }

    private Node findNode(int index) {
        int nodeIndex = 0;
        Node currentNode = this.head;

        while(nodeIndex != index) {
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
