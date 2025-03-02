package com.fb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class BeautifulNumbersInRangeTest {

    static Stream<String> arrayOf() { // Provide test data as a Stream
        return Stream.of("1,2,2", "56,100, 4", "100,1000,9", "8,8,1", "1001,100000,18",
                "75,300,5", "1,9,9", "9999,9999,1",
                "1,10,9", "10,100,9", "100,1000,9", "1,100,18", "1,1000,27", "500,1500,6", "777,777,1", "999,1000,1", "1000,2000,1"
        ); //for last set is - 1,2,3,3
    }

    @DisplayName("Comparing test effective method via bruteforce method")
    @ParameterizedTest(name = "Score set {0} gives the same result")
    //@ValueSource(strings = {"345", "123"})
    //@FieldSource("arrayOf")
    @MethodSource("arrayOf")
    void testGetUniformIntegerCountInInterval(String inputString) {
        String[] inputData = inputString.split(",");
        long A = Long.parseLong(inputData[0].strip());
        long B = Long.parseLong(inputData[1].strip());
        long expectedResult = Long.parseLong(inputData[2].strip());
        int result = BeautifulNumbersInRange.getUniformIntegerCountInInterval(A, B);
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testGetDigitsInNumberReturn3() {
        int result = BeautifulNumbersInRange.getDigitsInNumber(999L);
        Assertions.assertEquals(3, result);
    }

    @Test
    void testGetDigitsInNumberReturn10() {
        int result = BeautifulNumbersInRange.getDigitsInNumber(1234567891L);
        Assertions.assertEquals(10, result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme