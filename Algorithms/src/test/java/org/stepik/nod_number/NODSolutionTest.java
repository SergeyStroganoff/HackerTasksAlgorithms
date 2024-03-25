package org.stepik.nod_number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NODSolutionTest {

    @Test
    void getNodRecursive() {
        int commonDivider = NODSolution.getNodRecursive(2294528, 512);
        System.out.println(commonDivider);
        Assertions.assertEquals(256, commonDivider);
    }

    @Test
    void findNOD() {
        int commonDivider = NODSolution.findNOD(2294528, 512);
        System.out.println(commonDivider);
        Assertions.assertEquals(256, commonDivider);

    }
}