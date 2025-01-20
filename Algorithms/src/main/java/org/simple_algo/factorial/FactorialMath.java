package org.simple_algo.factorial;

import java.util.Scanner;

public class FactorialMath {
    // Метод возвращает факториал числа
    // n! = 1 * 2 * 3 * ... * n
    //n! = n * (n-1)/2
    // 0! = 1

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(FactorialMath.factorial(n));
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
