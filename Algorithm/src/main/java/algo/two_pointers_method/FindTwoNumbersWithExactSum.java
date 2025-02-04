package algo.two_pointers_method;

import java.util.Arrays;

/**
 * Найти две числа в отсортированном массиве, сумма которых равна заданному числу.
 */
public class FindTwoNumbersWithExactSum {

    public static void main(String[] args) {
        //List<Integer> array = new ArrayList<>(List.of(1, 45, 34, 23, 67, 4, 35, 667, 79, 2, 43, 46, 44, 24));
        //  array.sort((x, y) -> x > y ? -1 : x == y ? 0 : 1);
        //array.sort(Collections.reverseOrder());
        int[] array = {15, 45, 34, 23, 67, 4, 35, 667, 79, 2, 43, 46, 44, 24};
        Arrays.sort(array);

        int taskSum = 71;
        FindTwoNumbersWithExactSum thisClassInstance = new FindTwoNumbersWithExactSum();
        String answerText = Arrays.toString(thisClassInstance.getTwoNumbersBySum(array, taskSum));
        System.out.println(answerText);
    }

    public int[] getTwoNumbersBySum(int[] array, int sum) {
        int[] result = new int[2];
        if (array.length < 2) {
            return result;
        }
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int currentSum = array[leftIndex] + array[rightIndex];
            if (currentSum == sum) {
                result[0] = array[leftIndex];
                result[1] = array[rightIndex];
                return result;
            } else if (currentSum < sum) leftIndex++;
            else rightIndex--;
        }

        return result;
    }
}
