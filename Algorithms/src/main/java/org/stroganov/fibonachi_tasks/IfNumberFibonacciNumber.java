package org.stroganov.fibonachi_tasks;

// A number 'num' is a Fibonacci number if and only if one of 5*num^2 + 4 or 5*num^2 - 4 is a perfect square
// The time complexity of this solution is O(1)
// The space complexity of this solution is O(1)
// The solution is based on the fact that a number 'num' is a Fibonacci number if and only if one of 5*num^2 + 4 or 5*num^2 - 4 is a perfect square
public class IfNumberFibonacciNumber {

    public static boolean isFibonacci(int num) {
        // A number 'num' is a Fibonacci number if and only if one of 5*num^2 + 4 or 5*num^2 - 4 is a perfect square

        return isPerfectSquare(5 * num * num + 4) || isPerfectSquare(5 * num * num - 4);
    }
    public static boolean isPerfectSquare(int n) { //
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
