package com.shashank.dsa.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringAlgorithmsTest {
    @Test
    void longestSubstringWithoutRepeating() {
        assertEquals(3, StringAlgorithms.longestSubstringWithoutRepeating("abcabcbb"));
        assertEquals(1, StringAlgorithms.longestSubstringWithoutRepeating("bbbbb"));
        assertEquals(0, StringAlgorithms.longestSubstringWithoutRepeating(""));
        assertEquals(2, StringAlgorithms.longestSubstringWithoutRepeating("😀😃😀"));
    }

    @Test
    void palindromeIgnoresPunctuationAndCase() {
        assertTrue(StringAlgorithms.isAlphanumericPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(StringAlgorithms.isAlphanumericPalindrome("race a car"));
        assertTrue(StringAlgorithms.isAlphanumericPalindrome(".,!"));
    }
}
