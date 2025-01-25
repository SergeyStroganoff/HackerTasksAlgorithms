package algo.stepik.greatest_subsequence;

import java.util.Arrays;

public class SolutionBySorting {
    public static void main(String[] args) {
        int[] sample = {5, 10, 6, 12, 3, 24, 7, 8, 30};
        int maxSequenceLength = getGISBySorting(sample);
        System.out.println("MAx subsequence is: " + maxSequenceLength);
    }

    private static int getGISBySorting(int[] sample) {
        int[] sortArray = Arrays.copyOf(sample, sample.length);
        Arrays.sort(sortArray);
        Arrays.stream(sortArray).forEach((element) -> System.out.print(element + ", "));
        int[][] dp = calculateLCS(sample, sortArray);
        return dp[sample.length][sortArray.length];
    }

    public static int[][] calculateLCS(int[] arr1, int[] arr2) {
        System.out.println(" ");
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("arr2: " + Arrays.toString(arr2));
        int m = arr1.length;
        int n = arr2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) { //идем по строкам
            for (int j = 1; j <= n; j++) { //идем по столбцам
                if (arr1[i - 1] == arr2[j - 1]) { //если элементы равны то увеличиваем значение на 1 в диагональной ячейке
                    dp[i][j] = dp[i - 1][j - 1] + 1; //если элементы равны то увеличиваем значение на 1 в диагональной ячейке
                    System.out.print(dp[i][j] + "+");
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); //иначе берем максимальное значение из верхней и левой ячейки
                    System.out.print(dp[i][j] + "-");
                }
            }
            System.out.println(" ");

        }
        // Print the 2D array
        System.out.println("2D Array:");
        for (int in = 0; in <= m; in++) {
            for (int jn = 0; jn <= n; jn++) {
                System.out.print(dp[in][jn] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        } // Print the 2D array

        return dp;
    }
}
