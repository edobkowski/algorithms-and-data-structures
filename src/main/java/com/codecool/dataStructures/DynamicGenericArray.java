package com.codecool.dataStructures;

import java.util.Arrays;
import java.util.Collection;

// put your code here!
public class DynamicGenericArray<T> {
    private Object[] elements;
    private int size = 0;

    public DynamicGenericArray() {
        this(10);
    }

    public DynamicGenericArray(int size) {
        if(size < 0) {
            throw new IllegalArgumentException("Cannot create array of negative size");
        }
        this.elements  = new Object[size];
    }

    public DynamicGenericArray(Collection collection) {
        this.elements = collection.toArray();
        this.size = elements.length;
    }

    @SuppressWarnings("Unchecked")
    public T get(int index) {
        checkIndexEceptions(index);

        return (T) elements[index];
    }

    public void remove(int index) {
        checkIndexEceptions(index);
        this.elements[index] = null;

        if(index < this.size-1) {
            shiftLeft(index);
        }
        size--;
    }

    public void insert(int index, T element) {
        checkIndexEceptions(index);
        resize(++this.size);
        shiftRight(index);
        this.elements[index] = element;
    }

    public void add(T element) {
        resize(this.size + 1);
        this.elements[size++] = element;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.size; i++) {
            sb.append(elements[i]).append(" ");
        }

        return sb.toString().trim();
    }

    private void resize(int requiredSize) {
        if(requiredSize < 0) {
            throw new IllegalArgumentException("Cannot resize array to negative size");
        }

        int actualSize = this.elements.length;

        if(requiredSize > actualSize) {
            int newSize = (actualSize*3)/2 + 1; // grow an array by 1.5 times as optimal size;
            this.elements = Arrays.copyOf(this.elements, newSize);
        }
    }

    private void shiftLeft(int fromIndex) {
        for(int i = fromIndex+1; i < this.size; i++) {
            this.elements[i-1] = this.elements[i];
            this.elements[i] = null;
        }
    }

    private void shiftRight(int fromIndex) {
        for(int i = this.size; i > fromIndex; i--) {
            this.elements[i] = this.elements[i-1];
        }
    }

    private void checkIndexEceptions(int index) {
        if(index < 0 || index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
