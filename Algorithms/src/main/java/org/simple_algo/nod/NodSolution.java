package org.simple_algo.nod;

import java.util.Scanner;


//not effective solution

public class NodSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(findNOD(a, b));

    }

    public static int findNOD(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a == b) return a;
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        if (a == 0) return b;
        else return a;
    }
}


