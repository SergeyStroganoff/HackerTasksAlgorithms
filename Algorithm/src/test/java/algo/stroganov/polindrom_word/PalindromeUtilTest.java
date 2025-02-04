package algo.stroganov.polindrom_word;

import algo.simple_algo.palindrome.PalindromeEffective;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeUtilTest {

    @Test
    void isPalindrome() {
        //given
        String word = "madam";
        //when

        boolean result = PalindromeEffective.isPalindromeByIterationImproved(word);
        //then
        assertTrue(result);
    }

}