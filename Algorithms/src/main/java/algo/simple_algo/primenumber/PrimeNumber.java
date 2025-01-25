package algo.simple_algo.primenumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Проверка является ли число простое
 * Как работает алгоритм:
 * Числа меньше или равные 1 сразу исключаются.
 * Для оптимизации проверяем делители только до квадратного корня числа (Math.sqrt), так как все делители выше будут "зеркальными".
 * Если хотя бы одно число в диапазоне делит number нацело, число не является простым.
 * Если цикл завершился без нахождения делителей, число простое.
 */

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("Enter any int number:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int number = Integer.parseInt(reader.readLine());
            System.out.println(isPrime(number));
        } catch (IOException e) {
            System.out.println("Error while reading value");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
