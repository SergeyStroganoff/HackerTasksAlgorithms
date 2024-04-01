package org.stepik.greatest_subsequence.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionForGreatestSubsequence {
    public static void main(String[] args) throws IOException {
        // getting input data from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arrayLength = Integer.parseInt(reader.readLine());
        String[] arrayAsString = reader.readLine().split(" ");
        int[] array = Arrays.stream(arrayAsString).mapToInt(Integer::parseInt).toArray();
        // getting subsequence
        SolutionForGreatestSubsequence solution = new SolutionForGreatestSubsequence();
        List<Integer> subsequence = solution.lengthOfLIS(array);
        System.out.println(subsequence.size());
        subsequence.forEach(e -> System.out.print(e + " "));
    }

    public List<Integer> getGreatestSubSequenceNLLogN(int[] array) {
        if (array.length <= 1) {  // if array has only one element
            return List.of(array[0]);
        }
        int[] indexes = new int[array.length]; //massive for save privies index of element in subsequence
        int[] memoryArray = new int[array.length]; //massive for save subsequence
        Arrays.fill(indexes, Integer.MAX_VALUE);
        Arrays.fill(memoryArray, Integer.MAX_VALUE);
        memoryArray[0] = array[0]; //first element of subsequence
        indexes[0] = 0; //index of first element of subsequence
        int lengthSubseq = -1; //length of subsequence
        int indexOfLongestSubsequence = 0;
        for (int i = 1; i < array.length; ++i) { //start from second element
            indexes[i] = ceilIndex(memoryArray, 0, i, array[i]); //find ceil index for current element in subsequence array and save it in indexes array for current element of array sequence
            if (lengthSubseq <= indexes[i]) {
                lengthSubseq = indexes[i];
                indexOfLongestSubsequence = i;
            }
        }
        return getSubsequenceFromIndexes(array, indexes, indexOfLongestSubsequence);
    }

    private List<Integer> getSubsequenceFromIndexes(int[] array, int[] indexes, int indexOfLongestSubsequence) {
        List<Integer> integerList = new ArrayList<>();
        int prevValueFromIndex = indexes[indexOfLongestSubsequence];
        integerList.add(array[indexOfLongestSubsequence]);
        while (prevValueFromIndex != 0) {
            indexOfLongestSubsequence--;
            if (prevValueFromIndex - 1 == indexes[indexOfLongestSubsequence]) {
                prevValueFromIndex = indexes[indexOfLongestSubsequence];
                integerList.add(array[indexOfLongestSubsequence]);
            }
        }
        Collections.reverse(integerList);
        return integerList;
    }

    public static int ceilIndex(int[] subsequence, int startLeft, int startRight, int key) { //find ceil index for current element in subsequence array
        int left = startLeft;
        int right = startRight;
        int mid;
        int ceilIndex = 0;
        boolean ceilIndexFound = false;

        for (mid = (left + right) / 2; left <= right && !ceilIndexFound; mid = (left + right) / 2) { //binary search
            if (subsequence[mid] > key) { //if current element of subsequence array is greater than current element of array sequence
                right = mid - 1;
            } else if (subsequence[mid] == key) {
                ceilIndex = mid;
                ceilIndexFound = true;
            } else if (mid + 1 <= right && subsequence[mid + 1] >= key) {
                subsequence[mid + 1] = key;
                ceilIndex = mid + 1;
                ceilIndexFound = true;
            } else {
                left = mid + 1;
            }
        }
        if (!ceilIndexFound) {
            if (mid == left) {
                subsequence[mid] = key;
                ceilIndex = mid;
            } else {
                subsequence[mid + 1] = key;
                ceilIndex = mid + 1;
            }
        }

        return ceilIndex;
    }

    /**
     * For each number in nums, we perform the following steps:
     * If the number is greater than the last element of the last bucket (i.e., the largest element in the current subsequence), we append the number to the end of the list. This indicates that we have found a longer subsequence.
     * Otherwise, we perform a binary search on the list of buckets to find the smallest element that is greater than or equal to the current number. This step helps us maintain the property of increasing elements in the buckets.
     * Once we find the position to update, we replace that element with the current number. This keeps the buckets sorted and ensures that we have the potential for a longer subsequence in the future.
     * Below is the implementation of the above approach:
     *
     * @param nums
     * @return
     */

    public List<Integer> lengthOfLIS(int[] nums) {
        // Binary search approach
        int n = nums.length;
        List<Integer> subsequenceList = new ArrayList<>();

        // Initialize the answer list with the
        // first element of nums
        subsequenceList.add(nums[0]);

        for (int i = 1; i < n; i++) {
            if (nums[i] > subsequenceList.get(subsequenceList.size() - 1)) {
                // If the current number is greater
                // than the last element of the answer
                // list, it means we have found a
                // longer increasing subsequence.
                // Hence, we append the current number
                // to the answer list.
                subsequenceList.add(nums[i]);
            } else {
                // If the current number is not
                // greater than the last element of
                // the answer list, we perform
                // a binary search to find the smallest
                // element in the answer list that
                // is greater than or equal to the
                // current number.

                // The binarySearch method returns
                // the index of the first element that is not less than
                // the current number.
                int low = Collections.binarySearch(subsequenceList, nums[i]);
                // We update the element at the
                // found position with the current number.
                // By doing this, we are maintaining
                // a sorted order in the answer list.
                if (low < 0) {
                    low = -(low + 1);
                }
                subsequenceList.set(low, nums[i]);
                subsequenceList.forEach(e -> System.out.print(e + " "));
                System.out.println("");
            }
        }
        // The size of the answer list
        // represents the length of the
        // longest increasing subsequence.
        return subsequenceList;
    }
}
