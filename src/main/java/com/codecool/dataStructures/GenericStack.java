package com.codecool.dataStructures;

import com.codecool.dataStructures.exceptions.StackOverflowException;

public class GenericStack <T> {

    private Object[] array;
    private int size;
    private int top;

    public GenericStack(int size) {
        if(size < 1) {
            throw new IllegalArgumentException();
        }

        this.size = size;
        this.top = -1;
        this.array = new Object[size];
    }

    public T push(T element) throws StackOverflowException {
        if(this.top+1 == this.size) {
            throw new StackOverflowException("Limit of stack capacity reached");
        }

        this.array[++this.top] = element;
        return element;
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
