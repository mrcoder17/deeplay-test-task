package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ArraySort {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        fillArrayWithRandomNumbers(array, 20);
        System.out.println("Original array:");
        printArray(array);

        reorderArray(array);
        System.out.println("Sorted array:");
        printArray(array);
    }

    private static void fillArrayWithRandomNumbers(List<Integer> array, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(21) - 10);
        }
    }

    private static void printArray(List<Integer> array) {
        System.out.println(array);
    }

    private static void reorderArray(List<Integer> array) {
        List<Integer> odds = new ArrayList<>();
        List<Integer> zeros = new ArrayList<>();
        List<Integer> others = new ArrayList<>();

        for (int num : array) {
            if (num == 0) {
                zeros.add(num);
            } else if (num % 2 != 0) {
                odds.add(num);
            } else {
                others.add(num);
            }
        }

        Collections.sort(odds);
        others.sort(Collections.reverseOrder());

        array.clear();
        array.addAll(odds);
        array.addAll(zeros);
        array.addAll(others);
    }
}
