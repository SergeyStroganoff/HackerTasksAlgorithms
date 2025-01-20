package org.simple_algo.nod;

/**
 * Нахождение НОД двух чисел
 * Наибольший общий делитель (НОД) двух целых чисел a и b — это наибольшее число, на которое оба числа делятся без остатка.
 */
public class GCD {

    // Метод для нахождения НОД с использованием алгоритма Евклида
    public static int findGCD(int a, int b) {
        while (b != 0) { // Пока второе число не станет 0
            int temp = b; // Сохраняем значение b
            b = a % b;    // Остаток от деления a на b
            a = temp;     // Присваиваем a значение b
        }
        return a; // Возвращаем НОД
    }

    public static void main(String[] args) {
        int num1 = 60;
        int num2 = 500;

        int gcd = findGCD(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcd);
    }
}
