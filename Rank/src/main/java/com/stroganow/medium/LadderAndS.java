package com.stroganow.medium;

import java.util.*;

/**
 * Rules The game is played with a cubic die of  faces numbered  to .
 * Starting from square , land on square  with the exact roll of the die. If moving the number rolled would place the player beyond square , no move is made.
 * If a player lands at the base of a ladder, the player must climb the ladder. Ladders go up only.
 * If a player lands at the mouth of a snake, the player must go down the snake and come out through the tail. Snakes go down only.
 * Function Description
 * Complete the quickestWayUp function in the editor below. It should return an integer that represents the minimum number of moves required.
 * quickestWayUp has the following parameter(s):
 * ladders: a 2D integer array where each  contains the start and end cell numbers of a ladder
 * snakes: a 2D integer array where each  contains the start and end cell numbers of a snake
 */

public class LadderAndS {

    public static void main(String[] args) {
        List<List<Integer>> ladders = List.of(List.of(32, 62), List.of(42, 68), List.of(12, 98));
        System.out.println("### ");
        System.out.println(quickestWayUp(ladders, Collections.emptyList()));
    }

    /**
     * @param ladders 2D array
     * @param snakes  2D array
     * @return int - min count of die movies
     * Graph solution is used - each cell connected with next 6 cells with some edge cases
     */
    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        //initialization of array and set ladder cells and snake as the tails
        int[] board = new int[101];
        for (int n = 0; n <= 100; n++) {
            board[n] = n;
        }
        for (List<Integer> nextLadder : ladders) {
            board[nextLadder.get(0)] = nextLadder.get(1);
        }
        for (List<Integer> nextSnakes : snakes) {
            board[nextSnakes.get(0)] = nextSnakes.get(1);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        // first node
        int[] startPoint = {1, 0};
        queue.offer(startPoint);
        visited.add(1);
        while (!queue.isEmpty()) {
            int[] nextParentNode = queue.poll();
            if (nextParentNode[0] == 100) {
                return nextParentNode[1];
            }
            //iterate over children
            for (int i = nextParentNode[0] + 1; i <= nextParentNode[0] + 6; i++) {
                if (i < 101 && !visited.contains(board[i])) {
                    visited.add(board[i]);
                    visited.add(i);
                    queue.add(new int[]{board[i], nextParentNode[1] + 1});
                }
            }
        }
        return -1;
    }
}
