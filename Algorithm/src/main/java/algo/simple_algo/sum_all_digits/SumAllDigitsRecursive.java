package algo.simple_algo.sum_all_digits;

public class SumAllDigitsRecursive {
    // Метод возвращает сумму всех цифр числа
    // ссылка на алгоритм: https://en.wikipedia.org/wiki/Digital_root

    public int sumAllDigits(int n) {
        if (n == 0) { // базовый случай
            return 0;
        }
        return n + (sumAllDigits(n - 1));
    }
}
