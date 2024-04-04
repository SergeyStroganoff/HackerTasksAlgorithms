package org.sorting.chosee_sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortingByChoseTest {

    @Test
    void sort() {
        int[] array = {5, 4, 3, 2, 1};
        SortingByChose.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }
}