package algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void search() {
        int[] testArray  = {736, -2, 0, -5, 1, -2, -3, 8, 9, 4, -4, -1, 2, 5, 3, 6, 7, 10};

        assertTrue(BinarySearch.search(testArray, 0));
        assertTrue(BinarySearch.search(testArray, 8));
        assertTrue(BinarySearch.search(testArray, 736));
        assertFalse(BinarySearch.search(testArray, 20));
    }
}