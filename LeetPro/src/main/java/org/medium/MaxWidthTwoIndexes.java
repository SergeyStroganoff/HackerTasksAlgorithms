package org.medium;


import java.util.Stack;

/**
 * A Diapazon in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j].
 * The width of such a ramp is j - i.
 * <p>
 * Given an integer array nums, return the maximum width of a Diapazonramp in nums.
 * If there is no ramp in nums, return 0.
 * solution: monotone stack;
 */
public class MaxWidthTwoIndexes {

    public static void main(String[] args) {
        int[] testBuf = {6, 0, 8, 2, 1, 5};
        int[] testBuf2 = {9, 8, 1, 0, 1, 9, 4, 0, 4};
        int[] testBuf3 = {50000, 49999, 49998, 49997, 49996, 49995, 49994, 49993, 49992, 49991, 49990, 49989, 49988, 49987, 49986, 49985, 49984, 49983, 49982, 49981, 49980, 49979, 49978, 49977, 49976, 49975, 49974, 49973, 49972, 49971, 49970, 49969, 49968, 49967, 49966, 49965, 49964, 49963, 49962, 49961, 49960, 49959, 49958, 49957, 49956, 49955, 49954, 49953, 49952, 49951, 49950, 49949, 49948, 49947, 49946, 49945, 49944, 49943, 49942, 49941, 49940, 49939, 49938, 49937, 49936, 49935, 49934, 49933, 49932, 49931, 49930, 49929, 49928, 49927, 49926, 49925, 49924, 49923, 49922, 49921, 49920, 49919, 49918, 49917, 49916, 49915, 49914, 49913, 49912, 49911, 49910, 49909, 49908, 49907, 49906, 49905, 49904, 49903, 49902, 49901, 49900, 49899, 49898, 49897, 49896, 49895, 49894, 49893, 49892, 49891, 49890, 49889, 49888, 49887, 49886, 49885, 49884};
        System.out.println(maxWidthRampBF(testBuf));
        System.out.println(maxWidthRampBF(testBuf2));
        System.out.println(maxWidthRampBF(testBuf3));
    }

    /*
    Face decision - O(n2)
     */
    public static int maxWidthRamp(int[] array) {
        int maxD = 0;
        Stack<Integer> monoStack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (monoStack.isEmpty() || array[i] < array[monoStack.peek()]) {
                monoStack.push(i);
            }
        }
        // теперь идем с конца массива и проверяем каждый символ с символами в стеке
        for (int n = array.length - 1; n >= 0; n--) {
            while (!monoStack.isEmpty() && array[n] > array[monoStack.peek()]) {
                maxD = Math.max(maxD, n - monoStack.pop());
            }
        }
        return maxD;
    }

    /**
     * Alternative desigion based on crating addition array with the best (max element for each subarray)
     * Мы сожем двигать правый указатель до тех пор, пока левый ылемент гарантировано меньше лучьшего эелемента занесенного в индекс
     * right вспомогательного массива. Почему это работает. Потому что - right на каждом этапе может быть и не оптимален
     * но зато валиден, т.е. отвечает условию, но если значение стало меньше - это значит, что более right на право двигать
     * нет смысла, там не будет более больших значений ->    нам надо двигать левый указатель чтобы найти подходящий элемент.
     *
     * @param inputArray
     * @return
     */

    public static int maxWidthRampBF(int[] inputArray) {
        if (inputArray.length <= 1) {
            return 0;
        }
        // create array with index of max element in subarray (from i to end of array)
        //we go from the end to start end set max element
        int[] arrayTheBestMax = new int[inputArray.length];
        int lastArrayIndex = inputArray.length - 1;
        arrayTheBestMax[lastArrayIndex] = inputArray[lastArrayIndex];
        for (int i = lastArrayIndex - 1; i >= 0; i--) {
            arrayTheBestMax[i] = Math.max(arrayTheBestMax[i + 1], inputArray[i]);
        }
        int maxWidth = 0;
        int left = 0;
        int right = 0;
        // Traverse the array using left and right pointers
        while (right <= lastArrayIndex) {
            // Move left pointer forward if current left exceeds rightMax
            while (left < right && inputArray[left] > arrayTheBestMax[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }
        return maxWidth;
    }
}
