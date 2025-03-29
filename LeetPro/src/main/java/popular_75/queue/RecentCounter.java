package popular_75.queue;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 * Implement the RecentCounter class:
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
 * and returns the number of requests that has happened in the past 3000 milliseconds (including the new request).
 * Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 */

class RecentCounter {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
    }

    int capacity = 3000;
    private final Queue<Integer> queue = new ArrayDeque<>();

    public RecentCounter() {
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - capacity) {
            queue.remove();
        }
        queue.offer(t);
        return queue.size();
    }
}