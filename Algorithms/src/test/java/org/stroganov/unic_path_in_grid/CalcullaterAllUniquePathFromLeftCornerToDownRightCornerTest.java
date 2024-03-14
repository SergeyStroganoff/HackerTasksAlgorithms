package org.stroganov.unic_path_in_grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalcullaterAllUniquePathFromLeftCornerToDownRightCornerTest {

    private CalcullaterAllUniquePathFromLeftCornerToDownRightCorner calcullaterAllUniquePathFromLeftCornerToDownRightCorner = new CalcullaterAllUniquePathFromLeftCornerToDownRightCorner();

    @Test
    void uniquePaths() {
        int result = calcullaterAllUniquePathFromLeftCornerToDownRightCorner.uniquePaths(5, 5);
        assertEquals(70, result);
    }
}