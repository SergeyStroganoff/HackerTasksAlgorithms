package com.amaz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Задача сколько траков нужно чтобы перевезти все продукты из торгового центра с разными типами и ограничениями
 * <p>
 * Complete the 'calculateMinTrucks' function below.
 * <p>
 * The function is expected to return a LONG_INTEGER.
 * The function accepts following parameters:
 * 1. INTEGER_ARRAY quantity
 * 2. INTEGER num
 * 3. INTEGER k
 */
public class TracksForGoods {
    public static void main(String[] args)
/*      3        →    quantity[] size n = 3
        4        →    quantity = [4, 4, 3]
        3        →    capacity = 3
        3        →    max_parcels_of_same_typ */ {
        System.out.println(calculateMinTrucks(List.of(4, 4, 3), 3, 3));
        System.out.println(calculateMinTrucks2(List.of(4, 4, 3), 3, 3));
    }

    public static long calculateMinTrucks(List<Integer> quantity, int num, int k) {
        if (quantity.isEmpty()) {
            return 0;
        }
        if (quantity.size() == 1) {
            return quantity.get(0) / num;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(quantity);
        int trackCount = 0;
        while (!priorityQueue.isEmpty()) {
            int maxCapacity = num;
            int typeOfProduct = 0;
            List<Integer> remainGoods = new ArrayList<>();
            while (!priorityQueue.isEmpty() && typeOfProduct < k) {
                int nextProduct = priorityQueue.poll();
                typeOfProduct++;
                if (nextProduct > maxCapacity) {
                    remainGoods.add(nextProduct - maxCapacity);
                    break;
                }
                maxCapacity -= nextProduct;
            }
            priorityQueue.addAll(remainGoods);
            trackCount++;
        }
        return trackCount;
    }

    public static long calculateMinTrucks2(List<Integer> quantity, int maximumLoadTrack, int maxTypeOfGoods) {
        if (quantity.size() == 1) {
            return (long) Math.ceil(quantity.get(0) / (double) maximumLoadTrack);
        }
        // Создаем Max-Heap, чтобы сначала забирать товары с наибольшим количеством
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        priorityQueue.addAll(quantity);
        int truckCount = 0;
        while (!priorityQueue.isEmpty()) {
            int maxCapacity = maximumLoadTrack;
            int typeOfProduct = 0;
            List<Integer> remainingProducts = new ArrayList<>();
            // пока очередь из товаров не пуста и не превышен предел типов товаров - грузим товары
            while (!priorityQueue.isEmpty() && typeOfProduct < maxTypeOfGoods) {
                int currentProductsValue = priorityQueue.poll();
                typeOfProduct++;
                if (currentProductsValue > maxCapacity) {
                    remainingProducts.add(currentProductsValue - maxCapacity);
                    break; // Если этот тип товара уже исчерпал место в грузовике, останавливаем грузить грузовик и начинаем новый
                }
                // уменьшаем оставшуюся емкость грузовика
                maxCapacity -= currentProductsValue;
            }
            // Добавляем оставшиеся товары обратно в очередь, т.к. не вместили их в грузовик и идем грузить другой грузовик
            priorityQueue.addAll(remainingProducts);
            //учитываем грузовики;
            truckCount++;
        }
        return truckCount;
    }
}
