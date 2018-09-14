package com.codecool.dataStructures;

import org.junit.jupiter.api.BeforeAll;
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
}