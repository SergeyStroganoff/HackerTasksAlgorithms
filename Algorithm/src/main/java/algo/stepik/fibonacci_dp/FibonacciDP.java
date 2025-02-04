package algo.stepik.fibonacci_dp;

public class FibonacciDP {

    public static int fibonacciRecursion(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n <= 1) {
            return n;
        }
        memo[n] = fibonacciRecursion(n - 1, memo) + fibonacciRecursion(n - 2, memo);
        return memo[n];
    }
}
