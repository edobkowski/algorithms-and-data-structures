package com.codecool.dataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericDoublyLinkedListTest {

    @Test
    void headTest() {
        GenericDoublyLinkedList linkedList = createList(10);
        String expectedHead = "0";
        String actualHead = linkedList.head().toString();

        assertEquals(expectedHead, actualHead);
    }

    @Test
    void tailTest() {
        GenericDoublyLinkedList linkedList = createList(10);
        String expectedTail = "9";
        String actualTail = linkedList.tail().toString();

        assertEquals(expectedTail, actualTail);
    }

    @Test
    void addTest() {
        GenericDoublyLinkedList linkedList = new GenericDoublyLinkedList();
        linkedList.add(9);
        linkedList.add(4);
        String expectedValue = "9 4";
        String actualValue = linkedList.toString();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void removeTest() {
        GenericDoublyLinkedList linkedList = createList(10);
        linkedList.remove(2);
        linkedList.remove(0);
        String expectedValue = "1 3 4 5 6 7 8 9";
        String actualValue = linkedList.toString();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void insertTest() {
        GenericDoublyLinkedList linkedList = createList(10);
        linkedList.insert(2, 444);
        String expectedValue = "0 1 444 2 3 4 5 6 7 8 9";
        String actualValue = linkedList.toString();

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void getTest() {
        GenericDoublyLinkedList linkedList = createList(10);
        String expectedValue = "6";
        String actualValue = linkedList.get(6).toString();

        assertEquals(expectedValue, actualValue);
    }

    private GenericDoublyLinkedList createList(int size) {
        GenericDoublyLinkedList linkedList = new GenericDoublyLinkedList();
        for(int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        return linkedList;
    }
}