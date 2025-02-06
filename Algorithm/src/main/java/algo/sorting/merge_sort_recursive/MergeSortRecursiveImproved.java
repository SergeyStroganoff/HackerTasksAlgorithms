package algo.sorting.merge_sort_recursive;

import java.util.Arrays;

/**
 * Merge Sort — это алгоритм сортировки, который использует подход «разделяй и властвуй» (divide and conquer). Он рекурсивно разбивает массив на две половины, сортирует каждую половину, а затем объединяет (сливает) их в один отсортированный массив.
 * Основные шаги алгоритма:
 * Разделение (Divide):
 * Массив рекурсивно разбивается на две половины до тех пор, пока каждый подмассив не будет содержать один элемент или станет пустым.
 * Сортировка (Conquer): Когда массив разбит на подмассивы из одного элемента, он считается отсортированным (так как массив из одного элемента уже упорядочен).
 * Слияние (Merge): Отсортированные подмассивы объединяются в один отсортированный массив. Этот процесс повторяется рекурсивно, пока весь массив не будет отсортирован.
 * Например, подмассивы [27, 38] и [3, 43] объединяются в [3, 27, 38, 43].
 * В улучшенной версии мы не создаем новые два массива, а используем индексы старого массива; - будет посложней !!!
 * nLog-n по производительности, О(n) по памяти
 */

public class MergeSortRecursiveImproved {


    public static void main(String[] args) {
        int[] array = {-2, 4, 5, -1, 0, 3, -1, -7, -10, 12, 3, 7};
        int[] sortedArray = mergeSortRecursiveImprovedWrapper(array);
        System.out.println(Arrays.toString(sortedArray));
    }


    // Оптимизация путем передачи не новых массивов в рекурсию (половинок), а передавать только индексы старого массива
    private static int[] mergeSortRecursiveImprovedWrapper(int[] array) {
        if (array.length < 2) {
            return array;
        }
        return mergeSortRecursiveImproved(array, 0, array.length - 1);
    }

    private static int[] mergeSortRecursiveImproved(int[] array, int start, int end) {
        if (start >= end) {
            return new int[]{array[start]};
        }
        int middle = start + (end - start) / 2; // высчитываем середину относительно изменчивого старта и конца всякий раз -  старта каждый раз
        int[] arrayOne = mergeSortRecursiveImproved(array, start, middle);                                              //(Arrays.copyOfRange(array, 0, middle));
        int[] arrayTwo = mergeSortRecursiveImproved(array, middle + 1, end); //(Arrays.copyOfRange(array, middle, array.length));
        array = arraysMergeASC(arrayOne, arrayTwo);
        return array;
    }


    private static int[] arraysMergeASC(int[] arrayOne, int[] arrayTwo) {
        int[] result = new int[arrayOne.length + arrayTwo.length];
        int firstPointer = 0;
        int secondPointer = 0;
        int counter = 0;
        while (firstPointer < arrayOne.length && secondPointer < arrayTwo.length) {
            if (arrayOne[firstPointer] < arrayTwo[secondPointer]) {
                result[counter] = arrayOne[firstPointer];
                firstPointer++;
            } else {
                result[counter] = arrayTwo[secondPointer];
                secondPointer++;
            }
            counter++;
        }

        // если не дошли до конца массива то копируем остаток в конец результирующего
        if (firstPointer != arrayOne.length) {
            // (откуда, с какого индекса вкл, куда, с какого индекса, сколько элементов)
            System.arraycopy(arrayOne, firstPointer, result, counter, arrayOne.length - firstPointer);
        }
        if (secondPointer != arrayTwo.length) {
            System.arraycopy(arrayTwo, secondPointer, result, counter, arrayTwo.length - secondPointer);
        }
        return result;
    }
}




