package com.fb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class ScoreboardInferenceLevel2Test {

    static final String[] arrayOf = {"4334", "12345"};

    static Stream<String> arrayOf() { // Provide test data as a Stream
        return Stream.of("4334", "12345", "1", "0", "123456789");
    }

    @DisplayName("Comparing test effective method via bruteforce method")
    @ParameterizedTest(name = "Score set {0} gives the same result")
    //@ValueSource(strings = {"345", "123"})
    //@FieldSource("arrayOf")
    @MethodSource("arrayOf")
    void testGetMinProblemCount(String nextIntString) {

        int[] intBuf = Arrays.stream(nextIntString.split(""))
                .filter(x -> !x.isEmpty())  // More readable than Objects.equals(x, "")
                .mapToInt(Integer::parseInt) // Converts directly to an int array
                .toArray();

        int result = ScoreboardInferenceLevel2.getMinProblemCount(intBuf.length, intBuf);
        int resultBruteForce = ScoreBoardBruteForce.getMinProblemCount(intBuf.length, intBuf);
        Assertions.assertEquals(resultBruteForce, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme