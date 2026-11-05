package com.shashank.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SlidingWindowTest {
    @Test
    void maximumWindowSumHandlesNegativeWindows() {
        assertEquals(-3L, SlidingWindow.maximumWindowSum(new int[]{-5, -3, -7}, 1));
        assertEquals(9L, SlidingWindow.maximumWindowSum(new int[]{2, 1, 5, 1, 3, 2}, 3));
    }

    @Test
    void maximumWindowSumValidatesWindowSize() {
        assertThrows(IllegalArgumentException.class,
                () -> SlidingWindow.maximumWindowSum(new int[]{1, 2}, 0));
        assertThrows(IllegalArgumentException.class,
                () -> SlidingWindow.maximumWindowSum(new int[]{1, 2}, 3));
    }

    @Test
    void longestSubarrayAtMostKDistinct() {
        assertEquals(4, SlidingWindow.longestSubarrayAtMostKDistinct(
                new int[]{1, 2, 1, 2, 3}, 2));
        assertEquals(5, SlidingWindow.longestSubarrayAtMostKDistinct(
                new int[]{1, 1, 1, 1, 1}, 1));
        assertEquals(0, SlidingWindow.longestSubarrayAtMostKDistinct(new int[]{1, 2}, 0));
    }
}
