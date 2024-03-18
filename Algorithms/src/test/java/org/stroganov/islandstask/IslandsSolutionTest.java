package org.stroganov.islandstask;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IslandsSolutionTest {

    @Test
    void calculateNumIslands() {
        char[][] grid = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '0', '1', '1'},
                {'0', '0', '1', '0', '1'},
                {'0', '0', '0', '0', '0'}

        };
        int result = IslandsSolution.calculateNumIslands(grid);
        assertEquals(4, result);
    }
}