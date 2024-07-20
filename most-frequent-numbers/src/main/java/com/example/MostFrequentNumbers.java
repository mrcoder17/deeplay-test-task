package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MostFrequentNumbers {

    public static void main(String[] args) {
        int[] array = new int[20];
        fillArrayWithRandomNumbers(array);
        System.out.println("Original array:");
        printArray(array);

        List<Integer> mostFrequentNumbers = findMostFrequentNumber(array);
        System.out.println("Most frequent number(s): " + mostFrequentNumbers);
    }

    private static void fillArrayWithRandomNumbers(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10;
        }
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static List<Integer> findMostFrequentNumber(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        for (int num : array) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        List<Integer> mostFrequentNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentNumbers.add(entry.getKey());
            }
        }

        return mostFrequentNumbers;
    }
}