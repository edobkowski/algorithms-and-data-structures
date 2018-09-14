package com.codecool.dataStructures;

import java.util.List;

public class BinarySearchTree {

    class Node {
        private Integer value;
        private Node leftChild;
        private Node rightChild;

        Node(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return this.value;
        }

        public Node getLeftChild() {
            return this.leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return this.rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        public boolean hasLeftChild() {
            return this.leftChild != null;
        }

        public boolean hasRightChild() {
            return this.rightChild != null;
        }
    }

    private Node root;

    public void build(List<Integer> numbers) {
        int middleIndex = (int) Math.floor(numbers.size()/2);
        root = new Node(numbers.get(middleIndex));
        numbers.remove(middleIndex);

        for(Integer i : numbers) {
            addChild(root, i);
        }
    }

    public boolean search(Integer value) {
        return searchDeep(root, value);
    }

    private boolean searchDeep(Node parent, Integer value) {
        if(value.equals(parent.getValue())) { // use equals() for Integers out of Integer Pool
            return true;
        } else if(value <= parent.getValue() && parent.hasLeftChild()) {
            return searchDeep(parent.getLeftChild(), value);
        } else if (value > parent.getValue() && parent.hasRightChild()) {
            return searchDeep(parent.getRightChild(), value);
        } else {
            return false;
        }
    }

    private void addChild(Node parent, Integer value) {
        if(parent.getValue() >= value && parent.hasLeftChild()){
            addChild(parent.getLeftChild(), value);
        } else if(parent.getValue() >= value && !parent.hasLeftChild()) {
            Node leftChild = new Node(value);
            parent.setLeftChild(leftChild);
        } else if(parent.getValue() < value && parent.hasRightChild()) {
            addChild(parent.getRightChild(), value);
        } else {
            Node rightChild = new Node(value);
            parent.setRightChild(rightChild);
        }
    }
}
