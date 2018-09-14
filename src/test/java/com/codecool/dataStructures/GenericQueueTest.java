package com.codecool.dataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {

    @Test
    void enqueue() {
        GenericQueue queue = new GenericQueue();
        queue.enqueue(80);
        queue.enqueue(40);
        int expectedSize = 2;
        int actualSize = queue.size();

        assertEquals(expectedSize, actualSize);
    }
}