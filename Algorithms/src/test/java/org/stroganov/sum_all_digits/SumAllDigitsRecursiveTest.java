package org.stroganov.sum_all_digits;

import org.junit.jupiter.api.Test;
import org.simple_algo.sum_all_digits.SumAllDigitsRecursive;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumAllDigitsRecursiveTest {

    private SumAllDigitsRecursive sumAllDigitsRecursive = new SumAllDigitsRecursive();

    @Test
    void sumAllDigits() {
        int result = sumAllDigitsRecursive.sumAllDigits(100);
        assertEquals(5050, result);
    }
}