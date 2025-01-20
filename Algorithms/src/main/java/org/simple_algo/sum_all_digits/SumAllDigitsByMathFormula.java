package org.simple_algo.sum_all_digits;

public class SumAllDigitsByMathFormula {

    // Метод возвращает сумму всех цифр числа
    // ссылка на алгоритм: https://en.wikipedia.org/wiki/Digital_root

    public int sumAllDigits(int n) {
        return (n * (n + 1)) / 2;
    }
}
