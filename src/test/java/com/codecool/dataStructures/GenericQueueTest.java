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

    @Test
    void dequeue() {
        GenericQueue queue = createQueue(5);
        queue.dequeue();
        int expectedSize = 4;
        int actualSize = queue.size();
        String expectedResult = "1";
        String actualResult = queue.peek().toString();

        assertEquals(expectedSize, actualSize);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void peek() {
        GenericQueue queue = createQueue(5);
        String expectedResult = "0";
        String actualResult = queue.peek().toString();

        assertEquals(expectedResult, actualResult);

    }

    private GenericQueue createQueue(int size) {
        GenericQueue queue = new GenericQueue();
        for(int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        return queue;
    }
}