package algo.utils;

public class MultidimensionalArrayUtil {

    public static void print(boolean[][] array) {
        for (boolean[] row : array) {
            for (boolean element : row) {
                System.out.print((String.valueOf(element).charAt(0) == 't' ? "+" : "-") + " ");
            }
            System.out.println();
        }
    }
}
