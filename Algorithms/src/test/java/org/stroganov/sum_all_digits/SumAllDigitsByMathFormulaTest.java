package org.stroganov.sum_all_digits;

import org.junit.jupiter.api.Test;
import org.simple_algo.sum_all_digits.SumAllDigitsByMathFormula;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumAllDigitsByMathFormulaTest {

    private SumAllDigitsByMathFormula sumAllDigitsByMathFormula = new SumAllDigitsByMathFormula();
    @Test
    void sumAllDigits() {
        int result = sumAllDigitsByMathFormula.sumAllDigits(100);
        assertEquals(5050, result);
    }
}