package algo.stroganov.fibonachi_tasks;

import java.util.Scanner;

public class RestOfDivision {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(findFibonacciModulo(n, m));
    }

    public static long findFibonacciModulo(long n, long m) {
        long period = getPisanoPeriod(m);
        long remainder = n % period;
        return computeFibonacciModulo(remainder, m);
    }

    public static long getPisanoPeriod(long m) { //находим период Пизано
        long a = 0, b = 1, c;
        long period = 0;

        for (long i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            if (a == 0 && b == 1) {
                period = i + 1;
                break;
            }
        }
        return period;
    }

    public static long computeFibonacciModulo(long n, long m) {
        if (n <= 1) {
            return n % m;
        }
        long a = 0, b = 1, c = 1;
        for (long i = 2; i <= n; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
        }
        return c % m;
    }
}
