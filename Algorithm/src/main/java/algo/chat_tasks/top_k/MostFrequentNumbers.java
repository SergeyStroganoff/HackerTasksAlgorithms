package algo.chat_tasks.top_k;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MostFrequentNumbers {

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 4, 5, 3, 5, 4, 8, 6, 1, 1, 6, 6, 3, 7, 2, 1,};
        int howMany = 2;
        System.out.println(Arrays.toString(topKFrequent(array, howMany)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return new int[0];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> prQueue = new PriorityQueue<>((x1, x2) -> Integer.compare(x1[1], x2[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (prQueue.size() < k) {
                prQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            } else if (prQueue.peek()[1] < entry.getValue()) {
                prQueue.poll();
                prQueue.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = prQueue.poll()[0];
        }
        return result;
    }
}

