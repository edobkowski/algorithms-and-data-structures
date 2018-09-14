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

    @Test
    void addTest_RepeatingKeys() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.add("two", 1);
        hashTable.add("two", 3);
        hashTable.add("two", 2);
        int expectedSize = 1;
        int actualSize = hashTable.size();

        assertEquals(expectedSize, actualSize);
    }

    @Test
    void getTest() {
        HashTable<String, String> hashTable = new HashTable<>();
        hashTable.add("Ala", "ma kota");
        String expectedResult = "ma kota";
        String actualResult = hashTable.get("Ala");

        assertEquals(expectedResult, actualResult);
    }
}