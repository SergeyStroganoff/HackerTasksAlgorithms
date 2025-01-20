package org.yandex_handbook.number_permutations;

import org.simple_algo.factorial.FactorialMath;

import java.util.Scanner;

public class PermutationsUtil {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(FactorialMath.factorial(n));
    }

    // Метод возвращает факториал числа
    // n! = 1 * 2 * 3 * ... * n
    // n! = n * (n-1)/2
    // 0! = 1

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
