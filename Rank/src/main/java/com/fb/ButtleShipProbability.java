package com.fb;

public class ButtleShipProbability {

    public static void main(String[] args) {
        int[][] buffer = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1}
        };
        System.out.println(getHitProbability(3, 3, buffer));
    }


    public static double getHitProbability(int R, int C, int[][] G) {
        int ships = 0;
        // Write your code here
        for (int i = 0; i < G.length; i++) {
            for (int j = 0; j < G[0].length; j++) {
                if (G[i][j] == 1) {
                    ships++;
                }
            }

        }
        double result = (double) ships / (R * C);
        return result;
    }
}
