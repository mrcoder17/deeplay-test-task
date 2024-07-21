package com.example;

import java.util.Random;

/**
 * Класс решает задачу определения победителя в игре с бросанием костей с использованием метода Монте-Карло
 */
public class DiceGame {

    /**
     * Точка входа в программу. Метод задает последовательности чисел для двух игроков, количество бросков кубика
     * и количество симуляций, затем вычисляет и выводит вероятности победы каждого игрока или ничьей
     *
     * @param args аргументы не используются
     */
    public static void main(String[] args) {
        int[] player1Sequence = {4, 2, 4};
        int[] player2Sequence = {4, 4, 4};
        int numberOfRolls = 1000;
        int simulations = 100000;

        double[] probabilities = calculateProbabilities(player1Sequence, player2Sequence, numberOfRolls, simulations);

        System.out.println("Вероятность победы игрока 1: " + probabilities[0]);
        System.out.println("Вероятность победы игрока 2: " + probabilities[1]);
        System.out.println("Вероятность ничьей: " + probabilities[2]);
    }

    /**
     * Метод для вычисления вероятностей победы каждого игрока или ничьей с использованием метода Монте-Карло
     *
     * @param player1Sequence последовательность игрока 1
     * @param player2Sequence последовательность игрока 2
     * @param numberOfRolls количество бросков кубика
     * @param simulations количество симуляций
     * @return массив вероятностей [вероятность победы игрока 1, вероятность победы игрока 2, вероятность ничьей]
     */
    public static double[] calculateProbabilities(int[] player1Sequence, int[] player2Sequence, int numberOfRolls, int simulations) {
        int player1Wins = 0;
        int player2Wins = 0;
        int draws = 0;

        Random random = new Random();

        for (int i = 0; i < simulations; i++) {
            int[] rolls = new int[numberOfRolls];
            for (int j = 0; j < numberOfRolls; j++) {
                rolls[j] = random.nextInt(6) + 1;
            }

            int player1Score = countSequenceOccurrences(rolls, player1Sequence);
            int player2Score = countSequenceOccurrences(rolls, player2Sequence);

            if (player1Score > player2Score) {
                player1Wins++;
            } else if (player2Score > player1Score) {
                player2Wins++;
            } else {
                draws++;
            }
        }

        double player1WinProbability = (double) player1Wins / simulations;
        double player2WinProbability = (double) player2Wins / simulations;
        double drawProbability = (double) draws / simulations;

        return new double[]{player1WinProbability, player2WinProbability, drawProbability};
    }

    /**
     * Метод для подсчета количества вхождений последовательности в массиве бросков
     *
     * @param rolls массив бросков
     * @param sequence последовательность для поиска
     * @return количество вхождений последовательности
     */
    public static int countSequenceOccurrences(int[] rolls, int[] sequence) {
        int count = 0;
        for (int i = 0; i <= rolls.length - sequence.length; i++) {
            boolean match = true;
            for (int j = 0; j < sequence.length; j++) {
                if (rolls[i + j] != sequence[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
                i += sequence.length - 1;
            }
        }
        return count;
    }
}