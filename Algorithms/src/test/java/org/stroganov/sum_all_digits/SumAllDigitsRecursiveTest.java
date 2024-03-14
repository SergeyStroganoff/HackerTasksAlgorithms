package org.stroganov.sum_all_digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumAllDigitsRecursiveTest {

    private SumAllDigitsRecursive sumAllDigitsRecursive = new SumAllDigitsRecursive();

    @Test
    void sumAllDigits() {
        int result = sumAllDigitsRecursive.sumAllDigits(100);
        assertEquals(5050, result);
    }
}