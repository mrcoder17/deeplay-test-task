package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiceGameTest {

    @Test
    public void testCalculateProbabilitiesSuccess() {
        int[] player1Sequence = {4, 2, 4};
        int[] player2Sequence = {4, 4, 4};
        int numberOfRolls = 10;
        int simulations = 1000;

        double[] probabilities = DiceGame.calculateProbabilities(player1Sequence, player2Sequence, numberOfRolls, simulations);

        assertNotNull(probabilities);
        assertEquals(3, probabilities.length);
        assertTrue(probabilities[0] >= 0 && probabilities[0] <= 1);
        assertTrue(probabilities[1] >= 0 && probabilities[1] <= 1);
        assertTrue(probabilities[2] >= 0 && probabilities[2] <= 1);
    }

    @Test
    public void testCountSequenceOccurrencesSuccess() {
        int[] rolls = {1, 2, 3, 4, 2, 4, 5, 6, 4, 2, 4};
        int[] sequence = {4, 2, 4};
        int count = DiceGame.countSequenceOccurrences(rolls, sequence);
        assertEquals(2, count);
    }

    @Test
    public void testCountSequenceOccurrencesNoMatch() {
        int[] rolls = {1, 2, 3, 5, 6, 7, 8};
        int[] sequence = {4, 2, 4};
        int count = DiceGame.countSequenceOccurrences(rolls, sequence);
        assertEquals(0, count);
    }

    @Test
    public void testCountSequenceOccurrencesEdgeCase() {
        int[] rolls = {4, 2, 4, 4, 2, 4, 4, 2, 4};
        int[] sequence = {4, 2, 4};
        int count = DiceGame.countSequenceOccurrences(rolls, sequence);
        assertEquals(3, count);
    }

    @Test
    public void testCountSequenceOccurrencesEmptyArray() {
        int[] rolls = {};
        int[] sequence = {4, 2, 4};
        int count = DiceGame.countSequenceOccurrences(rolls, sequence);
        assertEquals(0, count);
    }

    @Test
    public void testCountSequenceOccurrencesSequenceLongerThanArray() {
        int[] rolls = {1, 2, 3};
        int[] sequence = {1, 2, 3, 4};
        int count = DiceGame.countSequenceOccurrences(rolls, sequence);
        assertEquals(0, count);
    }

    @Test
    public void testCalculateProbabilitiesLargeSimulations() {
        int[] player1Sequence = {1};
        int[] player2Sequence = {2};
        int numberOfRolls = 1;
        int simulations = 100000;

        double[] probabilities = DiceGame.calculateProbabilities(player1Sequence, player2Sequence, numberOfRolls, simulations);

        assertNotNull(probabilities);
        assertEquals(3, probabilities.length);
        assertTrue(probabilities[0] >= 0 && probabilities[0] <= 1);
        assertTrue(probabilities[1] >= 0 && probabilities[1] <= 1);
        assertTrue(probabilities[2] >= 0 && probabilities[2] <= 1);
    }
}