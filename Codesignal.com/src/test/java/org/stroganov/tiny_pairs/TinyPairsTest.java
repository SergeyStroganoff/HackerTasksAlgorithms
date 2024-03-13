package org.stroganov.tiny_pairs;

import org.junit.jupiter.api.Test;

class TinyPairsTest {

    private TinyPairs tinyPairs = new TinyPairs();

    @Test
    void checkTinyPairsInArray() {
        //given
        int[] array = {10, 6, 301, 145, 109};
        //when
        boolean result = tinyPairs.checkTinyPairsInArray(array);
        //then
        assert (result);
    }
}

