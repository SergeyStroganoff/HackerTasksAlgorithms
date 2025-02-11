package algo.monostack;

import java.util.Arrays;
import java.util.Stack;

/**
 * #monsStack NearestSmallerElement
 * Задача: Найти ближайший меньший элемент для каждого элемента массива
 * Дан массив целых чисел arr. Для каждого элемента массива найдите ближайший меньший элемент (NSE — Nearest Smaller Element) слева от него. Если такого элемента нет, верните -1.
 * <p>
 * Формат ввода:
 * Массив целых чисел arr, где 1 <= arr.length <= 10^5 и -10^9 <= arr[i] <= 10^9.
 * <p>
 * Формат вывода:
 * Массив result, где result[i] — это ближайший меньший элемент для arr[i]. Если такого элемента нет, result[i] = -1.
 * <p>
 * Пример:
 * Ввод:
 * arr = [4, 5, 2, 10, 8]
 * Вывод:
 * result = [-1, 4, -1, 2, 2]
 */

public class NearestSmallerElement {

    public static void main(String[] args) {
        int[] testArray = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(findNSE(testArray)));
    }

    private static int[] findNSE(int[] testArray) {
        int[] result = new int[testArray.length];
        Stack<Integer> integersStack = new Stack<>();
        for (int i = 0; i < testArray.length; i++) {
            while (!integersStack.isEmpty() && integersStack.peek() >= testArray[i]) {
                integersStack.pop();
            }
            // Если стек не пуст, ближайший меньший элемент — это элемент на вершине стека
            if (!integersStack.isEmpty()) {
                result[i] = testArray[integersStack.peek()];
            } else {
                // Если стек пуст, ближайшего меньшего элемента нет
                result[i] = -1;
            }

            // Добавляем текущий индекс в стек
            integersStack.push(i);
        }
        return result;
    }
}
