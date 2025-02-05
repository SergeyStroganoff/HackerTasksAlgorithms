package com.amaz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Дан лист транзакций пользователей, где первая цифра от кого и вторая кому поступили деньги.
 * Последняя цифра это сумма. Найти всех пользователей превысивших порог транзакций threshold
 * Если пользователь оправил деньги сам себе то это не считается отдельной транзакцией.
 */

public class ThresholdForTransactions {
    public static void main(String[] args) {
        System.out.println("Hello");
        List<String> testList = List.of("88 12 120", "12 90 45", "76 88 05");
        List<String> processLogs = processLogs(testList, 1);
        System.out.println(processLogs);
    }

    public static List<String> processLogs(List<String> logs, int threshold) {
        // Write your code here
        List<String> resultStringList = new ArrayList<>();
        TreeMap<String, Integer> users = new TreeMap<>();
        for (String nextString : logs) {
            String[] nextStringBuf = nextString.split(" ");
            String sender = nextStringBuf[0].trim().toLowerCase();
            String recipient = nextStringBuf[1].trim().toLowerCase();
            if (recipient.equals(sender)) {
                addToMap(users, recipient);
            } else {
                addToMap(users, sender);
                addToMap(users, recipient);
            }
        }
        for (var nextEntry : users.entrySet()) {
            System.out.println(nextEntry.getKey() + " &&  " + nextEntry.getValue());
        }
        for (var nextEntry : users.entrySet()) {
            if (nextEntry.getValue() >= threshold) {
                resultStringList.add(nextEntry.getKey());
            }
        }
        return resultStringList;
    }

    private static void addToMap(Map<String, Integer> users, String user) {
        users.merge(user, 1, Integer::sum);
    }
}
