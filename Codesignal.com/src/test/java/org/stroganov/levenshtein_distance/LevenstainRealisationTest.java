package org.stroganov.levenshtein_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevenstainRealisationTest {

   private LevenstainRealisation levenstainRealisation = new LevenstainRealisation();

    @Test
    void getLevenstainLength() {
        String str1 = "nordic";
        String str2 = "cortic";
        int result = levenstainRealisation.getLevenstainLength(str1, str2);
        assertEquals(2, result);
    }
}