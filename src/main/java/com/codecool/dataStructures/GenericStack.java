package com.codecool.dataStructures;

public class GenericStack <T> {

    private Object[] array;
    private int size;
    private int top;

    public GenericStack(int size) {
        if(size < 1) {
            throw new IllegalArgumentException();
        }

        this.size = size;
        this.array = new Object[size];
    }

    public T push() {
        return null;
    }

    public T pop() {
        return null;
    }

    public T peek() {
        return null;
    }

    public int size() {
        return this.size;
    }

    public int spaceLeft() {
        return this.size - (this.top + 1);
    }

    public int spaceTaken() {
        return this.top + 1;
    }

    public boolean empty() {
        return true;
    }
}
