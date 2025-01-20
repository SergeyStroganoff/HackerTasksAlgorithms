package org.simple_algo.factorial;

public class FactorialRecursive {


    /**
     * // Метод возвращает факториал числа
     * // ссылка на алгоритм: https://en.wikipedia.org/wiki/Factorial
     * Call Stack:
     * <p>
     * - factorial(3)
     * -  3 * factorial(2)
     * - 3 * (2 * factorial(1))
     * - 3 * (2 * (1 * factorial(0)))
     * -  3 * (2 * (1 * 1)) = 6
     * </p>
     */


    public int factorial(int n) {
        if (n == 0) { // базовый случай
            return 1;
        }
        return n * factorial(n - 1); // рекурсивный случай
    }
}
