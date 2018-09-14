package com.codecool.dataStructures;

import com.codecool.dataStructures.exceptions.EmptyQueueException;
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
    void dequeue() throws EmptyQueueException {
        GenericQueue queue = createQueue(5);
        String expectedResult = "0";
        String actualResult = queue.dequeue().toString();
        int expectedSize = 4;
        int actualSize = queue.size();
        String expectedHead = "1";
        String actualHead = queue.peek().toString();

        assertEquals(expectedSize, actualSize);
        assertEquals(expectedResult, actualResult);
        assertEquals(expectedHead, actualHead);
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