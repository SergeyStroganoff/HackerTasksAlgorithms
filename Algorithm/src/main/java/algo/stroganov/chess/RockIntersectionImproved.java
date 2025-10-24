package algo.stroganov.chess;
// Задача: На шахматной доске N*N стоят ладьи. Координаты каждой заданы двумя числами от 1 до N.
// Определить, сколько пар ладей бьют друг друга.
/**
 * Этот подход имеет временную сложность𝑂(𝑘+𝑁)
 * O(k+N), где k — количество ладей, а N — размер доски,
 * что значительно эффективнее для больших значений k.
 */

public class RockIntersectionImproved {

    public int rookIntersections(int chessDeskSize, int[][] rooksCoordinates) {
        if (chessDeskSize <= 0 || rooksCoordinates == null) {
            throw new IllegalArgumentException("Invalid input data");
        }

        int[] rows = new int[chessDeskSize];
        int[] cols = new int[chessDeskSize];

        // Подсчёт количества ладей в каждой строке и столбце
        for (int[] coord : rooksCoordinates) { //идем по строкам
            int row = coord[0] - 1; // Преобразование к индексу массива
            int col = coord[1] - 1; // Преобразование к индексу массива
            rows[row]++; //сколь x стоит в томе же ряду
            cols[col]++; // сколько y в том же ряду
        }

        int result = 0;

        // Подсчёт пар ладей, атакующих друг друга в строках
        for (int count : rows) { // считаем сочетание 2 любых ладей в ряду и наращиваем результат
            if (count > 1) {
                result += count * (count - 1) / 2;
            }
        }

        // Подсчёт пар ладей, атакующих друг друга в столбцах
        for (int count : cols) {
            if (count > 1) {
                result += count * (count - 1) / 2;
            }
        }

        return result;
    }

}
