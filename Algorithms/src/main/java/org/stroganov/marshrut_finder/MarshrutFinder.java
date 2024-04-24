package org.stroganov.marshrut_finder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarshrutFinder {

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        HashMap<String, String> rightOrder = new HashMap<>();
        HashMap<String, String> wrongOrder = new HashMap<>();
        String marshruts = null;
        try {
            marshruts = FileReaderUtil.readFile("marshrutlist.txt");
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        }

        String[] marshrutPairs = marshruts.split(",");

        for (String pair : marshrutPairs) {
            String[] pairArray = pair.split(":");
            rightOrder.put(pairArray[0], pairArray[1]);
            rightOrder.put(pairArray[1], pairArray[0]);
        }

        for (Map.Entry<String, String> entry : rightOrder.entrySet()) {
            //todo
        }
    }
}
