package algo.simple_algo.zerro_sum_in_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Найти три элемента сумма которых дает 0.
 * Сортируем массив и обходим в цикле, при каждой итерации двумя указателями ищем сумму равную нулю
 * Левый указатель ставим на следующий элемент на текущим а правый на конец массива. Логика в цикле вайл:
 * пока левый указатель меньше правого проверяем сумму трех элементов и если 0 то возвращаем, если больше то
 * смещаем правый указатель на лево +1 иначе смещаем левый вправо на один пока не сойдутся. Сложность O(n2)
 * O(log-n) - по памяти для сортировки.
 */
public class ZeroSumInArraySolution {
    public static void main(String[] args) {
        int[] array = {-2, 4, 5, -1, 0, 3, -1, -7, -10, 12, 3, 7};
        List<Integer> result = findZeroSumCombination(array);
        System.out.println(result);
    }

    private static List<Integer> findZeroSumCombination(int[] array) {
        // ege cases
        if (array.length < 3) {
            return Collections.emptyList();
        }
        List<Integer> resultList = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length - 2; i++) {
            // Пропуск дубликатов
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int sum = array[left] + array[i] + array[right];
                if (sum == 0) {
                    resultList.add(array[left]);
                    resultList.add(array[i]);
                    resultList.add(array[right]);
                    return resultList;
                }
                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return resultList;
    }
}
