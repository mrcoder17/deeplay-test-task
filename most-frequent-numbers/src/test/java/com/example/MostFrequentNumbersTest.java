package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MostFrequentNumbersTest {

    @Test
    public void testFillArrayWithRandomNumbers() {
        int[] array = new int[20];
        MostFrequentNumbers.fillArrayWithRandomNumbers(array);

        assertEquals(20, array.length);
        for (int num : array) {
            assertTrue(num >= -10 && num <= 10);
        }
    }

    @Test
    public void testFindMostFrequentNumberOneResult() {
        int[] array = {1, 2, 3, 1, 2, 1};
        List<Integer> result = MostFrequentNumbers.findMostFrequentNumber(array);
        List<Integer> expected = Arrays.asList(1);
        assertEquals(expected, result);
    }

    @Test
    public void testFindMostFrequentNumberSeveralResults() {
        int[] array = new int[]{1, 1, 2, 2, 2, 3, 3, 3};
        List<Integer> result = MostFrequentNumbers.findMostFrequentNumber(array);
        List<Integer> expected = Arrays.asList(2, 3);
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }

    @Test
    public void testFindMostFrequentNumberDifferentNums() {
        int[] array = new int[]{1, 2, 3, 4, 5};
        List<Integer> result = MostFrequentNumbers.findMostFrequentNumber(array);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5); // Все числа встречаются одинаковое количество раз
        assertTrue(result.containsAll(expected) && expected.containsAll(result));
    }


    @Test
    public void testFindMostFrequentNumberOneNum() {
        int[] array = new int[]{7, 7, 7, 7, 7};
        List<Integer> result = MostFrequentNumbers.findMostFrequentNumber(array);
        List<Integer> expected = Arrays.asList(7);
        assertEquals(expected, result);
    }
}
