package org.stroganov.west_mortage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class TaskFromSunWESTMortage {

    public class Solution {
        public static void main(String args[] ) throws Exception {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT */
            BufferedReader bufferedReader = new  BufferedReader(new InputStreamReader(System.in));
            String inputSrting = bufferedReader.readLine();
            LinkedHashMap<String, List<String>> hashMatrix  = new LinkedHashMap<>();
            String [] rowBuffer = inputSrting.split(";");
            for (String rowString : rowBuffer) {
                String [] rowValuesAndColumnName = rowString.split(":");
                hashMatrix.put(rowValuesAndColumnName[1], Arrays.asList( rowValuesAndColumnName[0].split(",")));
            }

        }
    }

}
