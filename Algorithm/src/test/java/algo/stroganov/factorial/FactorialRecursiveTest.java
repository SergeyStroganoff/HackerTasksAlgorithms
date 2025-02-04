package algo.stroganov.factorial;

import algo.simple_algo.factorial.FactorialRecursive;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialRecursiveTest {

    private FactorialRecursive factorialRecursive = new FactorialRecursive();

    @Test
    void factorial() {
        int result = factorialRecursive.factorial(5);
        assertEquals(120, result);
    }
}