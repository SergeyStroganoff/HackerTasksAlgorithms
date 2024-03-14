package org.stroganov.factorial;

public class FactorialMath {
    // Метод возвращает факториал числа
    // n! = 1 * 2 * 3 * ... * n
    //n! = n * (n-1)/2
    // 0! = 1

    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
