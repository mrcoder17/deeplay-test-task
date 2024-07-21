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
     * Разделяет данный массив на K частей таким образом, чтобы сумма элементов в i-й части была равна L + i,
     * где L - это сумма элементов в первой части
     *
     * @param array Входной массив целых чисел
     * @param K Количество частей, на которые необходимо разделить массив
     * @return Список из K частей, каждая часть является списком целых чисел. Если невозможно разделить массив
     *         указанным образом, возвращается null
     */
    public static List<List<Integer>> splitArrayIntoKParts(int[] array, int K) {
        if (K < 1 || K > array.length) {
            return null;
        }

        int totalSum = Arrays.stream(array).sum();

        int sumRequired = K * (K - 1) / 2;
        if ((totalSum - sumRequired) % K != 0) {
            return null;
        }

        int L = (totalSum - sumRequired) / K;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            result.add(new ArrayList<>());
        }

        return backtrack(array, result, K, 0, L) ? result : null;
    }

    /**
     * Рекурсивно пытается разделить массив на K частей с требуемыми суммами
     *
     * @param array Входной массив целых чисел
     * @param parts Список частей, который формируется
     * @param K Количество частей, на которые необходимо разделить массив
     * @param index Текущий индекс обрабатываемого элемента в массиве
     * @param L Сумма первой части
     * @return true, если массив можно разделить на K частей с требуемыми суммами, false в противном случае
     */
    private static boolean backtrack(int[] array, List<List<Integer>> parts, int K, int index, int L) {
        if (index == array.length) {
            for (int i = 0; i < K; i++) {
                int expectedSum = L + i;
                int sum = parts.get(i).stream().mapToInt(Integer::intValue).sum();
                if (sum != expectedSum) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < K; i++) {
            parts.get(i).add(array[index]);
            if (backtrack(array, parts, K, index + 1, L)) {
                return true;
            }
            parts.get(i).remove(parts.get(i).size() - 1);
        }

        return false;
    }
}