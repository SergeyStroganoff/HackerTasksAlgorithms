package com.codesignal.add_flor_array;

class Solution {
    public static void main(String[] args) {
        // Initializing a 2D array that represents an apartment building
        String[][] apartments = {
                {"Apt 101", "Apt 102"},
                {"Apt 201", "Apt 202"}
        };

        // Adding a new floor to the apartment building
        apartments = addNewFloor(apartments, new String[]{"Apt 301", "Apt 302"});

        for (String[] nextRow : apartments) {
            for (String nextString : nextRow) {
                System.out.println(nextString);
            }
        }

        // TODO: Make a walk visiting each apartment on every floor of the updated building.
    }

    // TODO: Add a method `addNewFloor` to add a new floor with apartments to our 'apartment building'.
    private static String[][] addNewFloor(String[][] old, String[] newArray) {
        String[][] result = new String[old.length + 1][old[0].length];
        System.arraycopy(old, 0, result, 0, old.length);
        result[result.length - 1] = newArray;
        return result;
    }
}
