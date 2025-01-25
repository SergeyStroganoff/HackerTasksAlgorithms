package algo.yandex_handbook.numbers_combinations;

import java.util.Scanner;

public class CombinationsUtils {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(getCombinations(n, m));
    }

    private static int getCombinations(int n, int m) {
        return factorial(n) / (factorial(n - m) * factorial(m));
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
