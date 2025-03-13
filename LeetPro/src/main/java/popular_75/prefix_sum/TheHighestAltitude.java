package popular_75.prefix_sum;

/**
 * There is a biker going on a road trip.
 * The road trip consists of n + 1 points at different altitudes.
 * The biker starts his trip on point 0 with altitude equal 0.
 * You are given an integer array gain of length n where gain[i] is the net gain in altitude between points
 * i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
 */
public class TheHighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        int[] gain2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currentAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }
        return maxAltitude;
    }
}
