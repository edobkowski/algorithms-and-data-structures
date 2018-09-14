package com.codecool.dataStructures;

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
    void pushTest() {
        GenericStack stack = new GenericStack(10);
        stack.push(5);
        stack.push(6);
        stack.push(8);
        int expectedSpaceTaken = 3;
        int actualSpaceTaken = stack.spaceTaken();
    }

    @Test
    @DisplayName("Test pushing too much elements on the stack")
    void pushTest_OverCapacity() {
        GenericStack stack = new GenericStack(1);
        stack.push(5);

        assertThrows(StackOverFlowException.class, () -> stack.push(6));
    }
}