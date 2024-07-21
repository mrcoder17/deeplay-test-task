package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SplitArrayTest {

    @Test
    public void testSplitArrayIntoKPartsSuccess() {
        int[] array = {10, 11, 7, 7, 12};
        int K = 2;
        List<List<Integer>> result = SplitArray.splitArrayIntoKParts(array, K);

        assertNotNull(result);
        assertEquals(K, result.size());

        int expectedSum1 = result.get(0).stream().mapToInt(Integer::intValue).sum();
        int expectedSum2 = result.get(1).stream().mapToInt(Integer::intValue).sum();
        int L = Math.min(expectedSum1, expectedSum2);

        assertTrue(expectedSum1 == L || expectedSum2 == L);
        assertTrue(expectedSum1 == L + 1 || expectedSum2 == L + 1);
    }

    @Test
    public void testSplitArrayIntoKPartsImpossible() {
        int[] array = {7, 8, 12, 1};
        int K = 3;
        List<List<Integer>> result = SplitArray.splitArrayIntoKParts(array, K);

        assertNull(result);
    }

    @Test
    public void testSplitArrayIntoKPartsSinglePart() {
        int[] array = {10, 11, 7, 7, 12};
        int K = 1;
        List<List<Integer>> result = SplitArray.splitArrayIntoKParts(array, K);

        assertNotNull(result);
        assertEquals(1, result.size());

        int sum = result.get(0).stream().mapToInt(Integer::intValue).sum();

        assertEquals(10 + 11 + 7 + 7 + 12, sum);
    }

    @Test
    public void testSplitArrayIntoKPartsZeroK() {
        int[] array = {10, 11, 7, 7, 12};
        int K = 0;
        List<List<Integer>> result = SplitArray.splitArrayIntoKParts(array, K);

        assertNull(result);
    }

    @Test
    public void testSplitArrayIntoKPartsNegativeK() {
        int[] array = {10, 11, 7, 7, 12};
        int K = -1;
        List<List<Integer>> result = SplitArray.splitArrayIntoKParts(array, K);

        assertNull(result);
    }

    @Test
    public void testSplitArrayIntoKPartsMorePartsThanElements() {
        int[] array = {1, 2, 3};
        int K = 4;
        List<List<Integer>> result = SplitArray.splitArrayIntoKParts(array, K);

        assertNull(result);
    }
}