package algo.dinamic_programming.minimum_editing_distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Вычислите расстояние редактирования двух данных непустых строк длины не более 10-2
 * содержащих строчные буквы латинского алфавита.
 * - d i s t a n c e
 * e d i - t i n g -
 * Вставка i,j-1
 * Удаление i-1,j
 * замена [i-1,j-1] + if diff -> +1 else +0;
 * <p>
 * Solution: we can on each step do: add, delete, change, nothing
 * We will create dp[][] with best score of editing
 */

public class MEDSolution {
    //veras-
    //-erast

    public static void main(String[] args) {
        String[] strings = getStrings();
        System.out.println(calcMinEditingDistance("short", "ports"));
    }

    public static String[] getStrings() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String one;
        String two;
        try {
            one = reader.readLine();
            two = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new String[]{one, two};
    }

    private static int calcMinEditingDistance(String first, String second) {
        char[] firstStringBuf = first.toCharArray();
        char[] secondStringBuf = second.toCharArray();

        int[][] dp = new int[firstStringBuf.length + 1][secondStringBuf.length + 1];
/*        for (int[] nextRaw : dp) {
            Arrays.fill(nextRaw, Integer.MAX_VALUE);
        }*/

        for (int i = 0; i <= firstStringBuf.length; i++) {
            for (int j = 0; j <= secondStringBuf.length; j++) {
                if (i == 0) {
                    // чтобы воссоздать строку j из строки i длинны ноль до префикса 0..j необходимо j вставок!
                    dp[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    // чтобы воссоздать строку i из j длинны ноль до префикса 0..i необходимо i вставок
                    dp[i][j] = i;
                    continue;
                }
                int diff = firstStringBuf[i - 1] == secondStringBuf[j - 1] ? 0 : 1;
                dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1), dp[i - 1][j - 1] + diff);
            }
        }
        multiDimessialArrayPrint(dp);
        return dp[firstStringBuf.length][secondStringBuf.length];
    }

    public static void multiDimessialArrayPrint(int[][] array) {
        for (int[] row : array) {
            for (int colVAAlle : row) {
                System.out.print("| " + colVAAlle + " |");
            }
            System.out.println("\n");
        }
    }
}
