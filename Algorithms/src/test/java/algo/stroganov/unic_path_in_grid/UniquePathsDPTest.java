package algo.stroganov.unic_path_in_grid;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UniquePathsDPTest {

    @Test
    void uniquePathsDPCalculator() {
        int result = UniquePathsDP.uniquePathsDPCalculator(4, 4);
        assertEquals(60, result);

    }


}