package com.codecool.dataStructures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericLinkedListTest {

    @Test
    @DisplayName("Test adding new elements to list with correct input")
    void addTest() {
        GenericLinkedList linkedList = new GenericLinkedList();
        linkedList.add(5);
        linkedList.add(10);
        String expectedResult = "5 10";
        String actualResult = linkedList.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test removing elements with correct index")
    void removeTest_WithCorrectInput() {
        GenericLinkedList linkedList = createList(10);
        linkedList.remove(0);
        String expectedResult = "1 2 3 4 5 6 7 8 9";
        String actualResult = linkedList.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test removing elements with incorrect index")
    void removeTest_WithIncorrectInput() {
        GenericLinkedList linkedList = createList(10);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.remove(20));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> linkedList.remove(-1));
    }

    private GenericLinkedList createList(int size) {
        GenericLinkedList linkedList = new GenericLinkedList();
        for(int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        return linkedList;
    }
}