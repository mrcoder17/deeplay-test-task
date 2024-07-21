package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Класс решает задачи генерации массива случайных целых чисел, вывода массива
 * и нахождения наиболее частого(-ых) элемента(-ов) в массиве
 */
public class MostFrequentNumbers {

    /**
     * Точка входа в приложение. Метод генерирует случайный массив, выводит его,
     * находит и выводит наиболее часто встречающиеся числа
     *
     * @param args аргументы не используются
     */
    public static void main(String[] args) {
        int[] array = new int[20];
        fillArrayWithRandomNumbers(array);
        System.out.println("Original array:");
        printArray(array);

        List<Integer> mostFrequentNumbers = findMostFrequentNumber(array);
        System.out.println("Most frequent number(s): " + mostFrequentNumbers);
    }

    /**
     * Заполняет массив случайными целыми числами в диапазоне [-10; 10]
     *
     * @param array массив, который будет заполнен случайными числами
     */
    private static void fillArrayWithRandomNumbers(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(21) - 10;
        }
    }

    /**
     * Выводит содержимое массива на экран
     *
     * @param array массив, который будет выведен на экран
     */
    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /**
     * Находит наиболее часто встречающееся(-ие) число(-а) в предоставленном массиве
     *
     * @param array массив, в котором необходимо найти наиболее частое(-ые) число(-а)
     * @return список наиболее часто встречающихся чисел
     */
    private static List<Integer> findMostFrequentNumber(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        // Нахождение максимальной частоты
        for (int num : array) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        // Нахождение всех чисел с максимальной частотой
        List<Integer> mostFrequentNumbers = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                mostFrequentNumbers.add(entry.getKey());
            }
        }

        return mostFrequentNumbers;
    }
}