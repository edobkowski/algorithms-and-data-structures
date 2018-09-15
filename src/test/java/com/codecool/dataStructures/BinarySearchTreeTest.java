package com.codecool.dataStructures;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private static List<Integer> numbers = new ArrayList<>();

    @BeforeAll
    static void generateValues() {
        for (int i = 0; i < 150; i++) {
            numbers.add(i * 2 + 5);
        }
    }

    @Test
    void buildTreeTest() {
        BinarySearchTree myTree = new BinarySearchTree();
        myTree.build(numbers);

        assertTrue(myTree.search(7));
        assertTrue(myTree.search(55));
        assertTrue(myTree.search(205));
        assertFalse(myTree.search(34535));
    }
}