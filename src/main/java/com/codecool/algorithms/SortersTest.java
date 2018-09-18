package com.codecool.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortersTest {

    private static final int[] expectedResult = {-5, -4, -3, -2, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 736};


    @Test
    void bubbleSortTest() {
        int[] testArray  = {736, -2, 0, -5, 1, -2, -3, 8, 9, 4, -4, -1, 2, 5, 3, 6, 7, 10};
        Sorters.bubbleSort(testArray);

        assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void insertionSortTest() {
        int[] testArray  = {736, -2, 0, -5, 1, -2, -3, 8, 9, 4, -4, -1, 2, 5, 3, 6, 7, 10};
        Sorters.insertionSort(testArray);

        assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void selectionSortTest() {
        int[] testArray  = {736, -2, 0, -5, 1, -2, -3, 8, 9, 4, -4, -1, 2, 5, 3, 6, 7, 10};
        Sorters.selectionSort(testArray);

        assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void mergeSortTest() {
        int[] testArray  = {736, -2, 0, -5, 1, -2, -3, 8, 9, 4, -4, -1, 2, 5, 3, 6, 7, 10};
        Sorters.mergeSort(testArray);

        assertArrayEquals(expectedResult, testArray);
    }

    @Test
    void quickSortTest() {
        int[] testArray  = {736, -2, 0, -5, 1, -2, -3, 8, 9, 4, -4, -1, 2, 5, 3, 6, 7, 10};
        Sorters.quickSort(testArray);

        assertArrayEquals(expectedResult, testArray);
    }
}