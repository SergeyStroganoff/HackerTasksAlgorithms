package algo.yandex_handbook.number_combinations_with_repititions;

import java.util.Scanner;

public class combinationsWithRepetitionsUtil {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(getCombinations(n, m));
    }

    private static int getCombinations(int n, int m) {
        return factorial(n + m - 1) / (factorial(n - 1) * factorial(m));
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
