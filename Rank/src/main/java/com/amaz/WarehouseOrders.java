package com.amaz;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Задача - Warehouse.
 * Warehouse обрабатывает заказы клиентов, представленные в виде массива orderProcessTime[i],
 * где i — индекс заказа.
 * Заказы обрабатываются последовательно, завершив один, переходят к следующему.
 * Amazon работает по сменам, где каждая смена имеет фиксированную длительность shiftDuration[i].
 * Если заказ не успевают обработать за смену, он переносится на следующую смену.
 * После завершения всех заказов в текущей смене процесс начинается заново с первого заказа в следующей смене.
 * Ваша задача — определить остаток времени обработки заказов после каждой смены.
 * <p>
 * 🔹 Разбор входных данных
 * <p>
 * n = 5 → количество заказов
 * orderProcessTime = [2, 4, 5, 1, 1] → время обработки каждого заказа
 * m = 5 → количество смен
 * shiftDuration = [1, 5, 1, 5, 2] → длительность каждой смены
 */

public class WarehouseOrders {

    public static void main(String[] args) {
        List<Integer> orders = List.of(2, 4, 5, 1, 1);
        List<Integer> shiftsDuration = List.of(1, 5, 1, 5, 2);
        calculatePendingOrders(orders, shiftsDuration).forEach(System.out::println);
    }

    public static List<Integer> calculatePendingOrders(List<Integer> orderProcessTime, List<Integer> shiftDuration) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> ordersQ = new ArrayDeque<>(orderProcessTime);
        for (int i = 0; i < shiftDuration.size(); i++) {
            if (ordersQ.isEmpty()) {
                break;
            }
            int nextOrderTime = ordersQ.poll();
            int nextShiftTime = shiftDuration.get(i);
            while (nextShiftTime - nextOrderTime >= 0) {
                nextShiftTime -= nextOrderTime;
                if (!ordersQ.isEmpty()) {
                    nextOrderTime = ordersQ.poll();
                }
            }
            int remainOrderTime = nextOrderTime - nextShiftTime;
            // возвращаем оставшееся время заказа в очередь с головы
            if (remainOrderTime > 0) {
                ordersQ.addFirst(remainOrderTime);
            }
            result.add(ordersQ.size());
        }
        return result;
    }

    public static List<Integer> calculatePendingOrdersImproved(List<Integer> orderProcessTime, List<Integer> shiftDuration) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> ordersQ = new ArrayDeque<>(orderProcessTime);
        for (int shiftTime : shiftDuration) {
            if (ordersQ.isEmpty()) {
                break;
            }
            int nextOrderTime = ordersQ.poll();
            while (shiftTime > 0 && nextOrderTime <= shiftTime) {
                shiftTime -= nextOrderTime;
                if (!ordersQ.isEmpty()) {
                    nextOrderTime = ordersQ.poll();
                } else {
                    nextOrderTime = 0; // Все заказы обработаны
                }
            }
            // Если остался недоработанный заказ, возвращаем его
            if (nextOrderTime > shiftTime && nextOrderTime > 0) {
                ordersQ.addFirst(nextOrderTime - shiftTime);
            }
            result.add(ordersQ.size());
        }
        return result;
    }

}
