package com.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArraySortTest {

    @Test
    public void testFillArrayWithRandomNumbers() {
        List<Integer> array = new ArrayList<>();
        ArraySort.fillArrayWithRandomNumbers(array, 20);

        assertEquals(20, array.size());
        for (Integer number : array) {
            assertTrue(number >= -10 && number <= 10);
        }
    }

    @Test
    public void testReorderArray() {
        List<Integer> array = new ArrayList<>(Arrays.asList(4, 1, 0, 2, 3, 4, 0, 5, 2, 1));
        ArraySort.reorderArray(array);

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 1, 3, 5, 0, 0, 4, 4, 2, 2));
        assertEquals(expected, array);
    }

    @Test
    public void testReorderArrayEmpty() {
        List<Integer> array = new ArrayList<>();
        ArraySort.reorderArray(array);

        assertTrue(array.isEmpty());
    }

    @Test
    public void testReorderArrayAllZero() {
        List<Integer> array = new ArrayList<>(Collections.nCopies(10, 0));
        ArraySort.reorderArray(array);

        List<Integer> expected = new ArrayList<>(Collections.nCopies(10, 0));
        assertEquals(expected, array);
    }

    @Test
    public void testReorderArrayAllOdd() {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13));
        ArraySort.reorderArray(array);

        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13));
        assertEquals(expected, array);
    }

    @Test
    public void testReorderArrayAllEven() {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14));
        ArraySort.reorderArray(array);

        List<Integer> expected = new ArrayList<>(Arrays.asList(14, 12, 10, 8, 6, 4, 2));
        assertEquals(expected, array);
    }
}