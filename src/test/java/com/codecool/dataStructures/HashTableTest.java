package com.codecool.dataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void addTest() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.add("One", 1);
        int expectedSize = 1;
        int actualSize = hashTable.size();

        assertEquals(expectedSize, actualSize);
    }
}