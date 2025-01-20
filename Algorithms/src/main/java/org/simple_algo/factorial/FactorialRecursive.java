package org.simple_algo.factorial;

public class FactorialRecursive {

    // Метод возвращает факториал числа
    // ссылка на алгоритм: https://en.wikipedia.org/wiki/Factorial

        public int factorial(int n) {
            if (n == 0) { // базовый случай
                return 1;
            }
            return n * factorial(n - 1); // рекурсивный случай
        }
}
