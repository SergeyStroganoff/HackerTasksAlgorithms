package com.fb;

import java.util.*;

public class MostFrequentNumbers {
    public static void main(String[] args) {
        int[] test = {3, 23, 3, 4, 1, 0, 4, 5, 4, 6, 5, 1, 2, 0};
        int k = 4;
        System.out.println(getMostFrequentNumbersEffective(test, k));
    }

    private static List<Integer> getMostFrequentNumbers(int[] array, int count) {
        if (array == null || array.length == 0) {
            return Collections.emptyList();
        }
        if (array.length == 1) {
            return List.of(array[0]);
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int nextValue : array) {
            map.put(nextValue, map.getOrDefault(nextValue, 0) + 1);
        }
        Collection<Integer> values = map.values();
        List<Integer> valList = new ArrayList<>(values);
        valList.sort(Comparator.reverseOrder());
        for (int i = 0; i < count; i++) {
            int nextVal = valList.get(i);
            for (var entry : map.entrySet()) {
                if (entry.getValue() == nextVal) {
                    result.add(entry.getKey());
                    if (result.size() >= count) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private static List<Integer> getMostFrequentNumbersEffective(int[] array, int count) {
        if (array == null || array.length == 0) {
            return Collections.emptyList();
        }
        if (array.length == 1) {
            return List.of(array[0]);
        }
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int nextValue : array) {
            map.put(nextValue, map.getOrDefault(nextValue, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((first, second) -> second.getValue() - first.getValue());
        priorityQueue.addAll(map.entrySet());
        for (int i = 0; i < count && !priorityQueue.isEmpty(); i++) {
            result.add(priorityQueue.poll().getKey());
        }
        return result;
    }
}
