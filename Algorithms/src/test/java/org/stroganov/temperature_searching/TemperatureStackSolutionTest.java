package org.stroganov.temperature_searching;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TemperatureStackSolutionTest {

    private int[] testArray = {13, 12, 15, 11, 9, 12, 16};
    private int[] actualArray = {2, 1, 4, 2, 1, 1, 0};

    @Test
    void dailyTemperaturesCalculate() {
        int[] result = TemperatureStackSolution.dailyTemperaturesCalculate(testArray);
        Assertions.assertArrayEquals(actualArray, result);
    }

    @Test
    void dailyTemperatures() {
        int[] result = TemperatureStackSolution.dailyTemperatures(testArray);
        Assertions.assertArrayEquals(actualArray, result);
    }
}