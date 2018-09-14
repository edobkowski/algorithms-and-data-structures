package com.codecool.dataStructures;

import com.codecool.dataStructures.exceptions.EmptyQueueException;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Test enqueue with priorities")
    void enqueueTest_WithPriorities() {
        GenericQueue<String> queue = new GenericQueue();
        queue.enqueue("kota", 1);
        queue.enqueue("Ala", 5);
        queue.enqueue("ma", 2);
        String expectedResult = "Ala";
        String actualResult = queue.peek();

        assertEquals(expectedResult, actualResult);
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
    @DisplayName("Test dequeue on empty queue. Should throw EmptyQueueException.")
    void dequeueTest_EmpyQueue() {
        GenericQueue queue = new GenericQueue();

        assertThrows(EmptyQueueException.class, () -> queue.dequeue());
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