package algo.stroganov.islandstask;
// 1. Реализовать метод подсчета количества островов в матрице

// РешениеЖ проходим по матрице и если встречаем 1, то запускаем метод deepTrace, который р
// рекурсивно обходит все смежные ячейки и помечает их как посещенные
// В конце возвращаем количество островов


public class IslandsSolution {
    public static int calculateNumIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int numberOfIslands = 0;
        int gridLength = grid.length;
        int gridWidth = grid[0].length;
        for (int i = 0; i < gridLength; i++) {
            for (int j = 0; j < gridWidth; j++) {
                if (grid[i][j] == '1') {
                    numberOfIslands++;
                    deepTrace(grid, i, j);
                }
            }
        }
        return numberOfIslands;
    }

    private static void deepTrace(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0'; // mark as visited
        deepTrace(grid, i + 1, j);
        deepTrace(grid, i - 1, j);
        deepTrace(grid, i, j + 1);
        deepTrace(grid, i, j - 1);
    }
}
