package algo.stroganov.sum_all_digits;

import algo.simple_algo.sum_all_digits.SumAllDigitsByMathFormula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumAllDigitsByMathFormulaTest {

    private SumAllDigitsByMathFormula sumAllDigitsByMathFormula = new SumAllDigitsByMathFormula();
    @Test
    void sumAllDigits() {
        int result = sumAllDigitsByMathFormula.sumAllDigits(100);
        assertEquals(5050, result);
    }
}