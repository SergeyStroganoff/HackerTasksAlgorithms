package popular_75.array_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

    // Given the array candies and the integer extraCandies,
    // where candies[i] represents the number of candies the ith kid has.
    // For each kid check if there is a way to distribute extraCandies among the kids
    // such that he or she can have the greatest number of candies among them.
    // Return a boolean array result of length n, where result[i] is true
    // if after the distribution of extraCandies, the ith kid will have the greatest number of candies,
    // or false otherwise.

    public static void main(String[] args) {
        KidsWithGreatestNumberOfCandies solution = new KidsWithGreatestNumberOfCandies();
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = solution.kidsWithCandies(candies, extraCandies);
        for (boolean res : result) {
            System.out.print(res + " ");
        }
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length == 0) {
            return Collections.emptyList();
        }
        List<Boolean> result = new ArrayList<>(candies.length);
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Integer.max(candy, max);
        }
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(Boolean.TRUE);
            } else {
                result.add(Boolean.FALSE);
            }
        }
        return result;
    }
}
