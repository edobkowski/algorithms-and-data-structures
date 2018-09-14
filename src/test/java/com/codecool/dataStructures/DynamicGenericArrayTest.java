package com.codecool.dataStructures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Your goal is to make all these tests pass!
// Do not modify this file.
class DynamicGenericArrayTest {

    @Test
    void DynamicIntArrayTest_WithInitialSize() {
        new DynamicGenericArray(15);
    }

    @Test
    void addTest() {
        DynamicGenericArray array = createArray(11);
        array.add(32);
        array.add(42);
        String result = "0 1 2 3 4 5 6 7 8 9 10 32 42";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest() {
        DynamicGenericArray array = createArray(11);
        array.remove(5);
        array.remove(0);
        String result = "1 2 3 4 6 7 8 9 10";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_LastItem() {
        DynamicGenericArray array = createArray(10);
        array.remove(9);
        String result = "0 1 2 3 4 5 6 7 8";
        assertEquals(result, array.toString());
    }

    @Test
    void removeTest_InvalidItem() {
        DynamicGenericArray array = createArray(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.remove(-1));
    }

    @Test
    void insertTest() {
        DynamicGenericArray array = createArray(11);
        array.insert(8, 223);
        array.insert(10, 654);

        String result = "0 1 2 3 4 5 6 7 223 8 654 9 10";
        assertEquals(result, array.toString());
    }

    @Test
    void insertTest_InvalidIndex() {
        DynamicGenericArray array = createArray(10);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> array.insert(100, 44));
    }

    private DynamicGenericArray createArray(int numOfElements) {
        DynamicGenericArray array = new DynamicGenericArray();
        for (int i = 0; i < numOfElements; ++i)
        {
            array.add(i);
        }
        return array;
    }
}