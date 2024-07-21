package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс решает задачи разделения массива на K частей, каждая из которых имеет последовательные суммы
 */
public class SplitArray {

    /**
     * Точка входа в приложение. Метод инициализирует массив и значение K, выводит исходные данные,
     * затем пытается разделить массив на K частей с последовательными суммами и выводит результат
     *
     * @param args аргументы не используются
     */
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

    /**
     * Разделяет массив на K частей с последовательными суммами
     *
     * @param array массив для разделения
     * @param K количество частей
     * @return список частей, если возможно выполнить разделение, иначе null
     */
    public static List<List<Integer>> splitArrayIntoKParts(int[] array, int K) {
        int totalSum = Arrays.stream(array).sum();
        int minSum = (2 * totalSum + K * (K - 1)) / (2 * K);

        if ((2 * totalSum + K * (K - 1)) % (2 * K) != 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            result.add(new ArrayList<>());
        }

        return backtrack(array, result, K, 0, minSum) ? result : null;
    }

    /**
     * Поиск с возвратом для разделения массива на K частей с последовательными суммами.
     *
     * @param array массив для разделения.
     * @param parts список частей, которые будут заполняться.
     * @param K количество частей.
     * @param index текущий индекс в массиве.
     * @param minSum минимальная сумма первой части.
     * @return true, если удалось разделить массив, иначе false.
     */
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