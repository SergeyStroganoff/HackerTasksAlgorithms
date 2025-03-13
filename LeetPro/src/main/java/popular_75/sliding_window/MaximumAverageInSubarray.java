package popular_75.sliding_window;

/**
 *
 */
public class MaximumAverageInSubarray {
    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 6};
        System.out.println(findMaxAverage(test, 2));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;
        int maxSum = 0;
        for (int m = 0; m < k; m++) {
            currentSum += nums[m];
        }
        if (k == nums.length) {
            return currentSum / (double) k;
        }
        maxSum = currentSum;
        for (int i = 0; i + k < nums.length; i++) {
            int rightBorder = i + k;
            currentSum = currentSum - nums[i] + nums[rightBorder];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum / (double) k;
    }
}
