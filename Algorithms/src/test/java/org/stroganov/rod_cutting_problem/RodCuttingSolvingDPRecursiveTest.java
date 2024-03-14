package org.stroganov.rod_cutting_problem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RodCuttingSolvingDPRecursiveTest {
    RodCuttingSolvingDPRecursive rodCuttingSolvingDPRecursive = new RodCuttingSolvingDPRecursive();

    @Test
    void maxProfit() {
        int[] prices = {0, 1, 5, 8, 9};
        int result = rodCuttingSolvingDPRecursive.cutRodDownAproach(prices, 4);
        assertEquals(10, result);
    }

    @Test
    void cutRodUpRecursiveApproach() {
        int[] prices = {0, 1, 5, 8, 9};
        int result = rodCuttingSolvingDPRecursive.cutRodUpRecursiveApproach(prices, 4);
        assertEquals(10, result);
    }
}