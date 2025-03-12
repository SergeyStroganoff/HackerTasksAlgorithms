package popular_75.two_pointers;


import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroesTP {
    public static void main(String[] args) {
        int[] testArray = {1, 0, 1, 0, 12, 15, 0};
        moveZeroes(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    // todo - move block of zerro
    public static void moveZeroes(int[] nums) {
        int rightPosition = nums.length;
        for (int i = 0; i < rightPosition; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < rightPosition - 1; j++) {
                    int k = 1;
                    while (j + k < rightPosition - 1 && nums[j + k] == 0) {
                        k++;
                    }
                    swap(j, j + k, nums);
                }
                rightPosition++;
            }
        }
    }


    private static void swap(int j, int i, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
