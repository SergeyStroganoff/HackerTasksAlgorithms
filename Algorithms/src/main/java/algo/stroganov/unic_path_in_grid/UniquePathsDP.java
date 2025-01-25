package algo.stroganov.unic_path_in_grid;

public class UniquePathsDP {

    public static int uniquePathsDPCalculator(int m, int n) {
        int[][] dp = new int[m][n];

        // Инициализация значений в первой строке и первом столбце как 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // Заполнение оставшихся ячеек таблицы
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Количество уникальных путей в текущей ячейке равно сумме путей из ячеек слева и сверху
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // Возвращаем количество уникальных путей из правого нижнего угла
        return dp[m - 1][n - 1];
    }
}
