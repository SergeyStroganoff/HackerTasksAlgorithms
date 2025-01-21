package org.sliding_window_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubStringWithUniqueCharsTest {

    @Test
    void lengthOfLongestSubstring() {
        // given
        String s = "abcd3abcdfg";
        //when
        LongestSubStringWithUniqueChars classInstance = new LongestSubStringWithUniqueChars();
        String length = classInstance.lengthOfLongestSubstring(s);
        //then
        assertEquals("6", length);
    }
}