package popular_75.queue;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 * The Dota2 senate consists of senators coming from two parties.
 * Now the Senate wants to decide on a change in the Dota2 game.
 * The voting for this change is a round-based procedure.
 * In each round, each senator can exercise one of the two rights:
 * <p>
 * Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
 * Announce the victory: If this senator found the senators who still have rights to vote are all from the same party,
 * he can announce the victory and decide on the change in the game.
 * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party.
 * Then, if there are n senators, the size of the given string will be n.
 * The round-based procedure starts from the first senator to the last senator in the given order.
 * This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 * Suppose every senator is smart enough and will play the best strategy for his own party.
 * Predict which party will finally announce the victory and change the Dota2 game.
 * The output should be "Radiant" or "Dire".
 */
public class DotaVoiting {

    public static void main(String... args) {
        String testString = "RRD";
        System.out.println(predictPartyVictory(testString));
    }

    /*
    we iterate over string using Queue and each iteration make a design
     */
    public static String predictPartyVictory(String senate) {
        String radiant = "Radiant";
        String dire = "Dire";
        int radianCounter = 0;
        int direCounter = 0;
        Queue<Character> senateQueue = new ArrayDeque<>();
        // initialization
        for (char nextChar : senate.toCharArray()) {
            senateQueue.add(nextChar);
        }
        while (radianCounter < senateQueue.size() && direCounter < senateQueue.size()) {
            char nextSenatorChar = senateQueue.poll();
            if (nextSenatorChar == 'R') {
                if (direCounter == 0) {
                    radianCounter++;
                    senateQueue.offer(nextSenatorChar);
                } else {
                    direCounter--;
                }
            }
            if (nextSenatorChar == 'D') {
                if (radianCounter == 0) {
                    direCounter++;
                    senateQueue.offer(nextSenatorChar);
                } else {
                    radianCounter--;
                }
            }
        }
        return radianCounter > 0 ? radiant : dire;
    }

    public static String predictPartyVictoryBestSolution(String senate) {
        Queue<Integer> radiantQueue = new ArrayDeque<>();
        Queue<Integer> direQueue = new ArrayDeque<>();
        int n = senate.length();
        // Populate initial queues with senator indices
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }
        // Process rounds until one party is eliminated
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.poll();
            int direIndex = direQueue.poll();
            // The senator with the smaller index bans the other senator
            if (radiantIndex < direIndex) {
                radiantQueue.offer(radiantIndex + n); // Move to the next round
            } else {
                direQueue.offer(direIndex + n); // Move to the next round
            }
        }
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }
}
