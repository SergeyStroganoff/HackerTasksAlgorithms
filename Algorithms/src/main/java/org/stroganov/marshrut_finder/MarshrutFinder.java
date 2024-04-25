package org.stroganov.marshrut_finder;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MarshrutFinder {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<String, String> rightOrder = new HashMap<>();
        String marshruts = null;
        File file = new File("");
        String absolutePath = file.getAbsolutePath();
        try {
            marshruts = FileReaderUtil.readFile(absolutePath + File.separator + "marshrutlist.txt");
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        String[] marshrutPairs = marshruts.split(",");

        for (String pair : marshrutPairs) {
            String[] pairArray = pair.split(":");
            rightOrder.put(pairArray[0], pairArray[1]);

        }
        Collection<String> endPoints = rightOrder.values();
        String firstCity;
        String secondCity = "";
        for (Map.Entry<String, String> entry : rightOrder.entrySet()) {
            if (!endPoints.contains(entry.getKey())) {
                firstCity = entry.getKey();
                secondCity = entry.getValue();
                stringBuilder.append(firstCity).append(" -> ");
                stringBuilder.append(secondCity).append(" -> ");
            }
        }

        while (!secondCity.isEmpty()) {
            if (rightOrder.containsKey(secondCity)) {
                secondCity = rightOrder.get(secondCity);
                stringBuilder.append(secondCity).append(" -> ");
            } else {
                secondCity = "";
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
