package org.stroganov.polindrom_word;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeUtilTest {

    @Test
    void isPalindromeMyDesign() {
        //given
        String word = "madam";
        //when
        boolean result = PalindromeUtil.isPalindromeStringBuilder(word);
        //then
        assertTrue(result);
    }

    @Test
    void isPalindrome() {
        //given
        String word = "madam";
        //when
        PalindromeUtil palindromeUtil = new PalindromeUtil();
        boolean result = palindromeUtil.isPalindrome(word);
        //then
        assertTrue(result);
    }

    @Test
    void isPalindromeStack() {
        //given
        String word = "madam";
        //when
        PalindromeUtil palindromeUtil = new PalindromeUtil();
        boolean result = palindromeUtil.isPalindromeStack(word);
        //then
        assertTrue(result);
    }
}