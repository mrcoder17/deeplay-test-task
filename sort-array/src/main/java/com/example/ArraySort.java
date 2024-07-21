package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Класс решает задачи заполнения массива случайными целыми числами, вывода массива
 * на экран и переупорядочивания элементов этого массива по определенным правилам
 */
public class ArraySort {

    /**
     * Точка входа в приложение. Метод генерирует случайный список, выводит его,
     * сортирует по определенным правилам и выводит отсортированный список
     *
     * @param args аргументы не используются
     */
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        fillArrayWithRandomNumbers(array, 20);
        System.out.println("Original array:");
        printArray(array);

        reorderArray(array);
        System.out.println("Sorted array:");
        printArray(array);
    }

    /**
     * Заполняет предоставленный список случайными целыми числами в диапазоне от -10 до 10
     *
     * @param array список, который будет заполнен случайными числами
     * @param size количество элементов в списке
     */
     public static void fillArrayWithRandomNumbers(List<Integer> array, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(21) - 10);
        }
    }

    /**
     * Выводит содержимое предоставленного списка на экран
     *
     * @param array список, который будет выведен на экран
     */
    public static void printArray(List<Integer> array) {
        System.out.println(array);
    }

    /**
     * Переупорядочивает элементы списка: сначала по неубыванию нечетные числа,
     * затем нули, затем прочие числа по невозрастанию
     *
     * @param array список, элементы которого необходимо переупорядочить
     */
    public static void reorderArray(List<Integer> array) {
        List<Integer> odd = new ArrayList<>();
        List<Integer> zero = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        // Разделение числа на нули, нечетные и четные
        for (int num : array) {
            if (num == 0) {
                zero.add(num);
            } else if (num % 2 != 0) {
                odd.add(num);
            } else {
                even.add(num);
            }
        }

        // Сортировка нечетных чисел по возрастанию
        Collections.sort(odd);

        // Сортировка четных чисел по убыванию
        even.sort(Collections.reverseOrder());

        // Очистка исходного списка и добавление в нужном порядке
        array.clear();
        array.addAll(odd);
        array.addAll(zero);
        array.addAll(even);
    }
}