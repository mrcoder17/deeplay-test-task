package com.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitArray {

    public static void main(String[] args) {
        int[] array = {10, 11, 7, 7, 12};
        int K = 2;
        System.out.println("Original array: " + Arrays.toString(array) + ", K = " + K);

        List<List<Integer>> result = splitArrayIntoKParts(array, K);
        if (result == null) {
            System.out.println("Impossible to split the array into " + K + " parts with consecutive sums.");
        } else {
            for (List<Integer> part : result) {
                System.out.println(part + ", sum = " + part.stream().mapToInt(Integer::intValue).sum());
            }
        }
    }

    public static List<List<Integer>> splitArrayIntoKParts(int[] array, int K) {
        int totalSum = Arrays.stream(array).sum();
        int minSum = (2 * totalSum + K * (K - 1)) / (2 * K);

        if ((2 * totalSum + K * (K - 1)) % (2 * K) != 0) {
            return null; // невозможно разделить
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            result.add(new ArrayList<>());
        }

        return backtrack(array, result, K, 0, minSum) ? result : null;
    }

    private static boolean backtrack(int[] array, List<List<Integer>> parts, int K, int index, int minSum) {
        if (index == array.length) {
            for (int i = 0; i < K; i++) {
                int sum = parts.get(i).stream().mapToInt(Integer::intValue).sum();
                if (sum != minSum + i) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < K; i++) {
            parts.get(i).add(array[index]);
            if (backtrack(array, parts, K, index + 1, minSum)) {
                return true;
            }
            parts.get(i).removeLast();
        }

        return false;
    }
}
