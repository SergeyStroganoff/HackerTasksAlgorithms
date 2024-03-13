package org.stroganov.levenshtein_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevenstainRealisationTest {

    LevenstainRealisation levenstainRealisation = new LevenstainRealisation();

    @Test
    void getLevenstainLength() {

        String str1 = "kitten";
        String str2 = "sitting";
        int result = levenstainRealisation.getLevenstainLength(str1, str2);
        assertEquals(3, result);
    }
}