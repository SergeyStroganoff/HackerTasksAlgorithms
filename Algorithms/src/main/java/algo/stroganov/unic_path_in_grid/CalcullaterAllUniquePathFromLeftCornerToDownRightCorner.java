package algo.stroganov.unic_path_in_grid;

// TODO: 2021-05-25

public class CalcullaterAllUniquePathFromLeftCornerToDownRightCorner {

    // Метод возвращает количество уникальных путей от левого верхнего угла до правого нижнего угла
    // в сетке размером m x n
    // ссылка на алгоритм: https://en.wikipedia.org/wiki/Lattice_path
    // количество уникальных путей = (m+n-2)!/(m-1)!(n-1)!
    // 1. Рекурсивный метод
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
    }
}
