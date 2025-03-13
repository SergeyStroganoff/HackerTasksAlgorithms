package popular_75.two_pointers;


import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroesTP {
    public static void main(String[] args) {
        int[] testArray = {0, 0};
        moveZeroesBest(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public void moveZeroes(int[] nums) {
        int snowBallSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowBallSize++;
            } else if (snowBallSize > 0) {
                int t = nums[i];
                nums[i] = 0;
                nums[i - snowBallSize] = t;
            }
        }
    }

    public void moveZeroesOther(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }


    // todo - move block of zerro
    public static void moveZeroesMySolution(int[] nums) {
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

    public static void moveZeroesBest(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int rightPosition = nums.length - 1;
        int left = 0;
        int right = 0;
        while (right <= rightPosition) {
            while (right < rightPosition && nums[right] == 0) {
                right++;
            }
            while (left < right && nums[left] != 0) {
                left++;
            }
            swap(left, right, nums);
            left++;
            right++;
        }
    }

    private static void swap(int j, int i, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void moveZeroesSecondSolution(int[] nums) {
        int left = -1;
        int curr = 0;
        int size = nums.length;
        while (curr < size) {
            if (nums[curr] != 0) {
                left++;
                swap(left, curr, nums);
            }
            curr++;
        }
    }
}
