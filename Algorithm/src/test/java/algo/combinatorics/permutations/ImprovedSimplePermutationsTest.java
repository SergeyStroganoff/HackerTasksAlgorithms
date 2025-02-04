package algo.combinatorics.permutations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class ImprovedSimplePermutationsTest {

    @Test
    void permute() {
        String testString = "Hello";
        Set<String> stringSet = new HashSet<>();
        ImprovedSimplePermutations.permute(testString.toCharArray(), 0, stringSet);
        System.out.println(stringSet.size());
        Assertions.assertEquals(60, stringSet.size());
    }
}