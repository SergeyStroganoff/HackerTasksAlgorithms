package org.stepik.greatest_subsequence.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionForLowSubsequence {

    public static void main(String[] args) throws IOException {
        // getting input data from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arrayLength = Integer.parseInt(reader.readLine());
        String[] arrayAsString = reader.readLine().split(" ");
        int[] array = Arrays.stream(arrayAsString).mapToInt(Integer::parseInt).toArray();
        // getting subsequence
        SolutionForLowSubsequence solution = new SolutionForLowSubsequence();
        List<Integer> subsequence = solution.getLowestSubSequenceNLLogN(array);
        System.out.println(subsequence.size());
        subsequence.forEach(e -> System.out.print(e + " "));
    }

    // these methods was modified to return the indexes of lowest subsequence !!!!
    public List<Integer> getLowestSubSequenceNLLogN(int[] array) {
        if (array.length <= 1) {  // if array has only one element
            return List.of(array[0]);
        }
        int[] indexes = new int[array.length]; //massive for save privies index of element in subsequence
        int[] memoryArray = new int[array.length]; //massive for save subsequence
        Arrays.fill(indexes, Integer.MAX_VALUE);
        Arrays.fill(memoryArray, Integer.MIN_VALUE);
        memoryArray[0] = array[0]; //first element of subsequence
        indexes[0] = 0; //index of first element of subsequence
        int lengthSubseq = -1; //length of subsequence
        int indexOfLongestSubsequence = 0;
        for (int i = 1; i < array.length; ++i) { //start from second element
            indexes[i] = ceilIndexMy(memoryArray, 0, indexOfLongestSubsequence, array[i]); //find ceil index for current element in subsequence array and save it in indexes array for current element of array sequence
            if (lengthSubseq <= indexes[i]) {
                lengthSubseq = indexes[i];
                indexOfLongestSubsequence = i;
            }
        }
        return getIndexesOfSubsequence(array, indexes, indexOfLongestSubsequence);
    }

    private List<Integer> getIndexesOfSubsequence(int[] array, int[] indexes, int indexOfLongestSubsequence) {
        List<Integer> integerList = new ArrayList<>();
        int prevValueFromIndex = indexes[indexOfLongestSubsequence];
        integerList.add(indexOfLongestSubsequence + 1);
        while (prevValueFromIndex != 0) {
            indexOfLongestSubsequence--;
            if (prevValueFromIndex - 1 == indexes[indexOfLongestSubsequence]) {
                prevValueFromIndex = indexes[indexOfLongestSubsequence];
                integerList.add(indexOfLongestSubsequence + 1);
            }
        }
        Collections.reverse(integerList);
        return integerList;
    }

    public static int findElementInMemoryArray(int[] subsequence, int startLeft, int startRight, int key) {
        int left = startLeft;
        int right = startRight;
        int mid = 0;
        int resultIndex = -1;
        if (key < subsequence[right - 1]) {  //first case
            subsequence[right] = key;
            return right;
        }
        if (key > subsequence[right] && key < subsequence[right - 1]) {  //second case
            subsequence[right] = key;
            return right;
        }
        while (left <= right) {  //binary search case 3
            mid = left + (right - left) / 2;
            if (subsequence[mid] == key) {
                return mid;
            } else if (key < subsequence[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (subsequence[mid] < key) { //case 4
            subsequence[mid] = key;
            return mid;
        }
        return resultIndex;
    }

    public static int floorIndex(int[] subsequence, int startLeft, int startRight, int key) {
        int left = startLeft;
        int right = startRight;
        int mid;
        int floorIndex = -1; // Initialize floorIndex to -1 (no floor found yet)
        boolean floorIndexFound = false;

        while (left <= right) { // Use a while loop instead of a for loop for binary search
            mid = left + (right - left) / 2; // Calculate mid using left and right pointers
            if (subsequence[mid] == key) { // If key is found, it is also the floor
                floorIndex = mid;
                floorIndexFound = true;
                subsequence[mid] = key;
                break;
            } else if (subsequence[mid] < key) { // Move left pointer to search right half
                floorIndex = mid; // Update floorIndex to current mid (potential floor)
                left = mid + 1;
            } else { // Move right pointer to search left half
                right = mid - 1;
            }
        }
        if (!floorIndexFound) { // If floorIndex is not found yet
            floorIndex = right; // Update floorIndex to the right pointer (potential floor)
            // subsequence[right] = key;
        }

        return floorIndex;
    }

    public static int ceilIndexMy(int[] subsequence, int left, int right, int key) { //find ceil index for current element in subsequence array
        int mid = (right - left) / 2;
        int ceilIndex = 0;
        boolean ceilIndexFound = false;

        while (left <= right) { // Use a while loop instead of a for loop for binary search
            if (subsequence[mid] == key) {// If key is found, it is also the ceil
                //  subsequence[mid + 1] = key;
                ceilIndex = mid + 1;
                left = mid + 1;
                ceilIndexFound = true;
            } else if (subsequence[mid] < key) { // Move left pointer to search right half
                right = mid - 1;
            } else { // Move right pointer to search left half
                ceilIndex = mid; // Update ceilIndex to current mid (potential ceil)
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
        }
        if (!ceilIndexFound) {
            if (mid == left) {
                subsequence[mid] = key;
                ceilIndex = mid;
            } else {
                subsequence[mid + 1] = key;
                ceilIndex = mid + 1;
            }
        } else {
            subsequence[ceilIndex] = key;
        }
        return ceilIndex;
    }


        public static int ceilIndex ( int[] subsequence, int startLeft, int startRight, int key)
        { //find ceil index for current element in subsequence array
            int left = startLeft;
            int right = startRight;
            int mid;
            int ceilIndex = 0;
            boolean ceilIndexFound = false;
            for (mid = (left + right) / 2; left <= right && !ceilIndexFound; mid = (left + right) / 2) { //binary search
                if (subsequence[mid] < key) { //if current element of subsequence array is greater than current element of array sequence
                    right = mid - 1;
                } else if (subsequence[mid] == key) {
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
}
