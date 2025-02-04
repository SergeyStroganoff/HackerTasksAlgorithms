package algo.interview_tasks;

/*
We have a two-dimensional board game involving snakes.  The board has two types of squares on it:
 +'s represent impassable squares where snakes cannot go, and 0's represent squares through which snakes can move.  Snakes can only enter on the edges of the board, and each snake can move in only one direction.  We'd like to find the places where a snake can pass through the entire board, moving in a straight line.

Here is an example board:

    col-->        0  1  2  3  4  5  6
               +----------------------
    row      0 |  +  +  +  0  +  0  0
     |       1 |  0  0  +  0  0  0  0
     |       2 |  0  0  0  0  +  0  0
     v       3 |  +  +  +  0  0  +  0
             4 |  0  0  0  0  0  0  0

Write a function that takes a rectangular board with only +'s and 0's, and returns two collections:

* one containing all of the row numbers whose row is completely passable by snakes, and
* the other containing all of the column numbers where the column is completely passable by snakes.

Sample Inputs:

board1 = [['+', '+', '+', '0', '+', '0', '0'],
          ['0', '0', '+', '0', '0', '0', '0'],
          ['0', '0', '0', '0', '+', '0', '0'],
          ['+', '+', '+', '0', '0', '+', '0'],
          ['0', '0', '0', '0', '0', '0', '0']]

board2 = [['+', '+', '+', '0', '+', '0', '0'],
          ['0', '0', '0', '0', '0', '+', '0'],
          ['0', '0', '+', '0', '0', '0', '0'],
          ['0', '0', '0', '0', '+', '0', '0'],
          ['+', '+', '+', '0', '0', '0', '+']]

board3 = [['+', '+', '+', '0', '+', '0', '0'],
          ['0', '0', '0', '0', '0', '0', '0'],
          ['0', '0', '+', '+', '0', '+', '0'],
          ['0', '0', '0', '0', '+', '0', '0'],
          ['+', '+', '+', '0', '0', '0', '+']]

board4 = [['+']]

board5 = [['0']]

board6 = [['0', '0'],
          ['0', '0'],
          ['0', '0'],
          ['0', '0']]

All test cases:
findPassableLanes(board1) => Rows: [4], Columns: [3, 6]
findPassableLanes(board2) => Rows: [], Columns: [3]
findPassableLanes(board3) => Rows: [1], Columns: []
findPassableLanes(board4) => Rows: [], Columns: []
findPassableLanes(board5) => Rows: [0], Columns: [0]
findPassableLanes(board6) => Rows: [0, 1, 2, 3], Columns: [0, 1]

Complexity Analysis:

r: number of rows in the board
c: number of columns in the board
*/

/**
 * Создаем два массива для строк и для колонок размером строк и колонок
 * Обходим двумерный массив по срокам (raws) и по колонкам во вложенном цикле.
 * Перед вложенным циклам прохода по строкам устанавливаем маркер - свободна ли строка
 * Если встречаем "+" в строке -> меняем маркер строки на false и помечаем соотвествующий индексу ряда
 * массив маркером - например false
 * Внутри первого внешнего цикла в конуе маркируем строку как свободную если не встрелии +
 * Вконце собираем результат с двух буферов - индексы строк и рядов свободных для прохода.
 */

import java.util.ArrayList;
import java.util.List;

public class SnakeTask {
    public static void main(String[] argv) {
        char[][] board1 = {{'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '+', '0'},
                {'0', '0', '0', '0', '0', '0', '0'}};

        char[][] board2 = {{'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '+', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}};

        char[][] board3 = {{'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '+', '0', '+', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}};

        char[][] board4 = {{'+'}};

        char[][] board5 = {{'0'}};

        char[][] board6 = {{'0', '0'},
                {'0', '0'},
                {'0', '0'},
                {'0', '0'}};

        char[][] board7 = {{}};

        System.out.println(solutionMethod(board1));
    }

    public static String solutionMethod(char[][] board) {
        //findPassableLanes(board1) => Rows: [4], Columns: [3, 6]
        final String rowConst = "Rows: ";
        final String columnConst = ", Columns: ";
        final String zeroValue = "[]";
        StringBuilder result = new StringBuilder(rowConst);
        if (board[0].length == 0) {
            return result
                    .append(zeroValue)
                    .append(columnConst)
                    .append(zeroValue)
                    .toString();
        }
        List<Integer> raws = new ArrayList<>();
        int[] columnsMarkerBuf = new int[board[0].length];
        for (int i = 0; i < board.length; i++) {
            boolean isRawEmpty = true;
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] == '+') {
                    columnsMarkerBuf[k] = 1;
                    isRawEmpty = false;
                }
            }
            if (isRawEmpty) raws.add(i); //
        }

        result.append(raws)
                .append(columnConst);

        for (int j = 0; j < columnsMarkerBuf.length; j++) {
            if (columnsMarkerBuf[j] == 0) {
                result.append("[").append(j).append("]");
            }
        }
        return result.toString();
    }
}

