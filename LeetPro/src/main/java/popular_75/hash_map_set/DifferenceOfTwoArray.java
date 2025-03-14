package popular_75.hash_map_set;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
 * answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
 */

public class DifferenceOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {2, 4, 6, 6};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> setOne = new HashSet<>();
        HashSet<Integer> setTwo = new HashSet<>();

        for (int nextInt : nums1) {
            setOne.add(nextInt);
        }
        for (int nextInt : nums2) {
            setTwo.add(nextInt);
        }

        for (int nextValue : nums1) {
            if (setTwo.contains(nextValue)) {
                setOne.remove(nextValue);
                setTwo.remove(nextValue);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>(setOne));
        result.add(new ArrayList<Integer>(setTwo));
        return result;
    }

    public static List<List<Integer>> findDifferenceImproved(int[] nums1, int[] nums2) {
        Set<Integer> setOne = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> setTwo = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<Integer> diffOne = setOne.stream().filter(n -> !setTwo.contains(n)).collect(Collectors.toList());
        List<Integer> diffTwo = setTwo.stream().filter(n -> !setOne.contains(n)).collect(Collectors.toList());

        return Arrays.asList(diffOne, diffTwo);
    }

}
