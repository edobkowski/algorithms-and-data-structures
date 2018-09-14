package com.codecool.dataStructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class KeyValue <K, V> {
    private K key;
    private V value;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return this.key;
    }

    V getValue() {
        return this.value;
    }

    void setKey(K key) {
        this.key = key;
    }

    void setValue(V value) {
        this.value = value;
    }
}

@SuppressWarnings("Unchecked")
public class HashTable <K, V> {

    private int size = 0;
    private int capacity;
    private List<KeyValue>[] elements;

    public HashTable() {
        this(10);
    }

    public HashTable(int capacity) {
        this.elements = new LinkedList[this.capacity];
    }

    public void add(K key, V value) {
        ensureSpace(this.size+1);
        int keyIndex = key.hashCode() % capacity;   // compute index in the range from 0 to capacity

        List<KeyValue> linkedList = elements[keyIndex];

        for(KeyValue kv : linkedList) {
            if(kv.getKey().equals(key)) {
                kv.setValue(value);
                return;
            }
        }

        linkedList.add(new KeyValue(key, value));
        this.size++;
    }

    public V get(K key) {
        return null;
    }

    public void remove(K key) {

    }

    public void clearAll() {

    }

    public int size() {
        return this.size;
    }

    private void ensureSpace(int requiredSize) {
        if(requiredSize < 0) {
            throw new IllegalArgumentException("Cannot resize array to negative size");
        }
        if(requiredSize > this.capacity) {
            int newCapacity = (this.capacity*3)/2+1;
            this.elements = Arrays.copyOf(elements, newCapacity);
        }
    }
}
