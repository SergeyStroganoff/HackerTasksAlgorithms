package org.stepik.greatest_subsequence.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        // getting input data from console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arrayLength = Integer.parseInt(reader.readLine());
        String[] arrayAsString = reader.readLine().split(" ");
        int[] array = Arrays.stream(arrayAsString).mapToInt(Integer::parseInt).toArray();
        // getting subsequence
        if (array.length == 1) {
            System.out.println("1");
            System.out.println("1");
            return;
        }
        List<Integer> integerList = new ArrayList<>();
        int[] memory = new int[array.length];
        int[] prev = new int[array.length]; //massive for save privios index of element in subsequence
        Arrays.fill(memory, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] <= array[i] && memory[j] < memory[i] + 1) {
                    memory[j] = memory[i] + 1;
                    prev[j] = i;
                }
            }
        }
        // getting subsequence;
        int maxSubsequenceValue = 1;
        int indexOfMaxSequenceValue = 0;
        for (int n = 0; n < memory.length; n++) {
            if (memory[n] > memory[indexOfMaxSequenceValue]) {
                maxSubsequenceValue = memory[n];
                indexOfMaxSequenceValue = n;
            }
        }
        while (indexOfMaxSequenceValue != -1) {
            integerList.add(indexOfMaxSequenceValue+1);
            indexOfMaxSequenceValue = prev[indexOfMaxSequenceValue];
        }
        Collections.reverse(integerList);

        System.out.println(maxSubsequenceValue);
        integerList.forEach(x -> System.out.print(x + " "));
    }
}
