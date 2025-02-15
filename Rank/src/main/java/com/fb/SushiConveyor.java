package com.fb;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * There areN dishes in a row on a kaiten belt, with the
 * ith dish being of typeDi
 * <p>
 * Some dishes may be of the same type as one another.
 * You're very hungry, but you'd also like to keep things interesting.
 * The N dishes will arrive in front of you, one after another in order,
 * and for each one you'll eat it as long as it isn't the same type as any of the previous K dishes you've eaten.
 * You eat very fast, so you can consume a dish before the next one gets to you.
 * Any dishes you choose not to eat as they pass will be eaten by others.
 * Determine how many dishes you'll end up eating.
 * Please take care to write a solution which runs within the time limit.
 */
public class SushiConveyor {

    public static void main(String[] args) {
        System.out.println(getMaximumEatenDishCount(6, new int[]{1, 2, 3, 3, 2, 1}, 1));
    }

    /**
     * More effective design
     *
     * @param N
     * @param D
     * @param K
     * @return
     */
    public static int getMaximumEatenDishCount(int N, int[] D, int K) {
        Queue<Integer> dishQueue = new ArrayDeque<>();
        Set<Integer> memory = new HashSet<>();
        int countDish = 0;
        for (int nextDishType : D) {
            if (!memory.contains(nextDishType)) {
                // eat dish
                dishQueue.add(nextDishType);
                memory.add(nextDishType);
                countDish++;
                if (dishQueue.size() > K) {
                    Integer withdraw = dishQueue.poll();
                    memory.remove(withdraw);
                }
            } // else pas dish
        }
        // Write your code here
        return countDish;
    }
}
