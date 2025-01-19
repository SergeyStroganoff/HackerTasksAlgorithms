package org.stroganov.west_mortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TaskFromSunWESTMortage {

    public static String getStringFromConsole() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString;
        try {
            inputString = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputString;
    }

    public String createHTMLTable(String inputString) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        HashMap<String, List<String>> rowsValuesMap = new HashMap<>();
        List<String> columnNames = new ArrayList<>();
        columnNames.add("-");
        String[] rowBuffer = inputString.split(";"); //делим на строки - колонки
        for (String rowString : rowBuffer) {
            String[] rowValuesAndColumnName = rowString.split(":");  //делим на значения и название колонки
            columnNames.add(rowValuesAndColumnName[1]); //добавляем название колонки
            List<String> rowValues = Arrays.asList(rowValuesAndColumnName[0].split(",")); //делим на значения конкретной колонки
            for (int i = 0; i < rowValues.size() - 1; i += 2) { //добавляем значения в мапу - берем только значения
                List<String> oneValueOfColumnAsList = new ArrayList<>(Collections.singletonList(rowValues.get(i + 1).trim()));
                rowsValuesMap.merge(rowValues.get(i).trim(), oneValueOfColumnAsList, (oldValue, newValue) -> {
                    oldValue.addAll(oneValueOfColumnAsList);
                    return oldValue;
                });
            }
        }

        for (Map.Entry<String, List<String>> entry : rowsValuesMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


        StringBuilder result = new StringBuilder("<table border=\"1\">");
        result.append("<tr>");
        for (String columnName : columnNames) {
            result.append("<th>").append(columnName).append("</th>");
        }
        result.append("</tr>");
        for (Map.Entry<String, List<String>> entry : rowsValuesMap.entrySet()) {
            result.append("<tr>");
            result.append("<td>").append(entry.getKey()).append("</td>");
            for (String value : entry.getValue()) {
                result.append("<td>").append(value).append("</td>");
            }
            result.append("</tr>");
        }
        result.append("</table>");
        System.out.println(result.toString());
        return result.toString();
    }
}


