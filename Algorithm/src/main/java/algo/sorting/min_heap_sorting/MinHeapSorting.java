package algo.sorting.min_heap_sorting;


import java.util.Arrays;

/**
 * Сортировка куча. Разбиваем весь массив на две части - уже отсортированный масив с конца и
 * heap - оставшаяся часть которая будет последовательно уменьшаться.
 * Изначально строим кучу из всего массива минус последний элемент
 * С головы  кучи всегда будет находиться максимальный элемент
 * Каждый раз мы перекидываем элемент с головы на следующу позицию хвоста. При этом сжимаем раздел кучи на
 * 1 а второй уже отсортированный отдел увеличивается таким образом.
 */
public class MinHeapSorting {

    public static void main(String[] args) {
        int[] testArray = {5, 1, 9, 45, 2, 8, 11, 23, 0};
        heapSorting(testArray);
        System.out.println(Arrays.toString(testArray));

    }

    public static void heapSorting(int[] array) {
        int heapSize = array.length - 1;
        buildHeap(array);
        for (int i = heapSize; i > 0; i--) {
            swap(array, i, 0);
            shiftDownElementInHeap(array, array[0], i - 1);
        }
    }

    private static void buildHeap(int[] array) {
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            shiftDownElementInHeap(array, i, array.length - 1);
        }
    }

    private static void shiftDownElementInHeap(int[] array, int i, int size) {
        while (true) {
            int indexLeftChild = 2 * i + 1;
            int indexRightChild = 2 * i + 2;
            int currentParrent = i; // Изначально предполагаем, что родитель — наибольший

            if (indexLeftChild <= size && array[indexLeftChild] > array[currentParrent]) {
                currentParrent = indexLeftChild;
            }

            if (indexRightChild <= size && array[indexRightChild] > array[currentParrent]) {
                currentParrent = indexRightChild;
            }

            if (currentParrent == i) {
                break; // Если ничего не поменялось - значит текущий элемент на своем месте
                // или уже нечего менять - выходим.
            }

            swap(array, i, currentParrent); // меняем предыдущего родителя с новым местами
            i = currentParrent; // Переход к следующему уровню вниз
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
