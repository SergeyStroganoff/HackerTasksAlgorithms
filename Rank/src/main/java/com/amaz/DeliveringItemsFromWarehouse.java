package com.amaz;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * На складе накоплены посылки, курьер может забрать в день не больше чем самый маленький
 * остаток посылок на одном из складе.
 * Используем очередь с приоритетом и всегда забираем минимальное колличество поысо - прибавляя день к доставке
 */

public class DeliveringItemsFromWarehouse {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(2, 3, 4, 3, 3));
        List<Integer> integers2 = new ArrayList<>(List.of(1000, 0, 3));
        int res = minDaysToDeliverParcelsImproved(integers2);
        System.out.println(res);
    }

    public static int minDaysToDeliverParcelsImproved(List<Integer> parcels) {
        // Write your code here
        if (parcels.size() == 1) {
            return 1;
        }
        int days = 0;
        int alreadySetParcelCount = 0;
        PriorityQueue<Integer> postOffices = new PriorityQueue<>(parcels);
        while (!postOffices.isEmpty()) {
            int currentParcelCount = postOffices.poll();
            if (currentParcelCount != 0 && currentParcelCount > alreadySetParcelCount) {
                alreadySetParcelCount = currentParcelCount;
                days++;
            }
        }
        return days;
    }
}
