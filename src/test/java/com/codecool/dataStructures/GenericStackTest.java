package com.codecool.dataStructures;

import com.codecool.dataStructures.exceptions.StackOverflowException;
import com.codecool.dataStructures.exceptions.StackUnderflowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericStackTest {

    @Test
    @DisplayName("Test stack initialisation with incorrect size inputs")
    void initialisationTest_WrongInput() {
        assertThrows(IllegalArgumentException.class, () -> new GenericStack(0));
        assertThrows(IllegalArgumentException.class, () -> new GenericStack(-20));
    }

    @Test
    @DisplayName("Test pushing elements on the stack")
    void pushTest() throws StackOverflowException{
        GenericStack stack = new GenericStack(10);
        stack.push(5);
        stack.push(6);
        stack.push(8);
        int expectedSpaceTaken = 3;
        int actualSpaceTaken = stack.spaceTaken();

        assertEquals(expectedSpaceTaken, actualSpaceTaken);
    }

    @Test
    @DisplayName("Test pushing too much elements on the stack")
    void pushTest_OverCapacity() throws StackOverflowException{
        GenericStack stack = new GenericStack(1);
        stack.push(5);

        assertThrows(StackOverflowException.class, () -> stack.push(6));
    }

    @Test
    @DisplayName("Test poping elements from the stack")
    void popTest() throws StackOverflowException, StackUnderflowException {
        GenericStack<Integer> stack = new GenericStack<>(10);
        stack.push(5);
        stack.push(6);
        int expectedRemovedValue = 6;
        int actualRemovedValue = stack.pop();
        int expectedSpaceTaken = 1;
        int actualSpaceTaken = stack.spaceTaken();

        assertEquals(expectedSpaceTaken, actualSpaceTaken);
    }

    @Test
    @DisplayName("Test poping elements from the empty stack")
    void popTest_FromEmpty() throws StackOverflowException, StackUnderflowException {
        GenericStack stack = new GenericStack(1);
        stack.push(5);
        stack.pop();

        assertThrows(StackUnderflowException.class, () -> stack.pop());
    }

    @Test
    @DisplayName("Test peeking element on the stack")
    void peekTest() throws StackOverflowException {
        GenericStack<Integer> stack = createStack(5);
        int expectedValue = 4;
        int actualValue = stack.peek();
        int expectedSpaceTaken = 5;
        int actualSpaceTaken = stack.spaceTaken();

        assertEquals(expectedValue, actualValue);
        assertEquals(expectedSpaceTaken, actualSpaceTaken);
    }

    @Test
    @DisplayName("Test calculating space left on the stack")
    void spaceLeftTest() throws StackOverflowException {
        GenericStack stack = createStack(10);
        int expectedValue = 0;
        int actualValue = stack.spaceLeft();

        assertEquals(expectedValue, actualValue);
    }

    private GenericStack createStack(int size) throws StackOverflowException {
        GenericStack<Integer> stack = new GenericStack<>(size);
        for(int i = 0; i < size; i++) {
            stack.push(i);
        }

        return stack;
    }
}