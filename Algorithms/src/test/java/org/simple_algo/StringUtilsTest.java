package org.simple_algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StringUtilsTest {

    @Test
    void isPalindromeByIteration() {
        boolean isPalindrome = StringUtils.isPalindromeByIteration("топот");
        assertTrue(isPalindrome);
    }
}