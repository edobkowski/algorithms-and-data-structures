package com.codecool.dataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {

    @Test
    void enqueue() {
        int expectedSize = 2;
        GenericQueue queue = createQueue(expectedSize);
        int actualSize = queue.size();

        assertEquals(expectedSize, actualSize);
    }

    private GenericQueue createQueue(int size) {
        GenericQueue queue = new GenericQueue();
        for(int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        return queue;
    }
}