package algo.stepik.fibonacci_dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FibonacciDPTest {

    @Test
    void fibonacciRecursion() {
        int result = FibonacciDP.fibonacciRecursion(10, new int[111]);
        assertEquals(55, result);
    }
}