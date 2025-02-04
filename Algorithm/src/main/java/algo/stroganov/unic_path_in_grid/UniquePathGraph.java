package algo.stroganov.unic_path_in_grid;

public class UniquePathGraph {

    public static int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, visited);
    }

    private static int dfs(int row, int col, int m, int n, boolean[][] visited) {
        // Базовый случай: если текущая позиция находится за пределами прямоугольника или уже посещена
        if (row >= m || col >= n || visited[row][col]) {
            return 0;
        }
        // Если достигнута правая нижняя ячейка, возвращаем 1 (найден уникальный путь)
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        // Помечаем текущую ячейку как посещенную
        visited[row][col] = true;
        // Рекурсивно ищем уникальные пути, двигаясь вправо и вниз
        int right = dfs(row, col + 1, m, n, visited);
        int down = dfs(row + 1, col, m, n, visited);
        // Суммируем количество уникальных путей справа и снизу
        int uniquePaths = right + down;
        // Снимаем пометку с текущей ячейки для обратного отслеживания пути
        visited[row][col] = false;
        return uniquePaths;
    }
}
