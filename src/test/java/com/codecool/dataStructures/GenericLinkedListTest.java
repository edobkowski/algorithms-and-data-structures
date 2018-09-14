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
        linkedList.remove(5);
        String expectedResult = "1 2 3 4 5 7 8 9";
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

    @Test
    @DisplayName("Test inserting value at correct index")
    void insertTest_WithCorrectInput() {
        GenericLinkedList linkedList = createList(10);
        linkedList.insert(2, 67);
        linkedList.insert(3, 67);

        String expectedResult = "0 1 67 67 2 3 4 5 6 7 8 9";
        String actualResult = linkedList.toString();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test inserting value at incorrect index")
    void insertTest_WithInCorrectInput() {
        GenericLinkedList linkedList = createList(10);

        assertThrows(ArrayIndexOutOfBoundsException.class, linkedList.insert(-1, 30));
        assertThrows(ArrayIndexOutOfBoundsException.class, linkedList.insert(20, 30));
    }

    private GenericLinkedList createList(int size) {
        GenericLinkedList linkedList = new GenericLinkedList();
        for(int i = 0; i < size; i++) {
            linkedList.add(i);
        }

        return linkedList;
    }
}