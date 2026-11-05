package com.shashank.dsa.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DynamicProgrammingTest {
    @Test
    void minimumCoinsHandlesPossibleAndImpossibleAmounts() {
        assertEquals(3, DynamicProgramming.minimumCoins(new int[]{1, 2, 5}, 11));
        assertEquals(-1, DynamicProgramming.minimumCoins(new int[]{2}, 3));
        assertEquals(0, DynamicProgramming.minimumCoins(new int[]{2, 5}, 0));
        assertEquals(-1, DynamicProgramming.minimumCoins(new int[0], 7));
    }

    @Test
    void minimumCoinsValidatesInputs() {
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.minimumCoins(new int[]{1, 0}, 3));
        assertThrows(IllegalArgumentException.class,
                () -> DynamicProgramming.minimumCoins(new int[]{1}, -1));
    }

    @Test
    void lisIsStrictAndHandlesEmptyInput() {
        assertEquals(4, DynamicProgramming.longestIncreasingSubsequenceLength(
                new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(1, DynamicProgramming.longestIncreasingSubsequenceLength(
                new int[]{2, 2, 2}));
        assertEquals(0, DynamicProgramming.longestIncreasingSubsequenceLength(new int[0]));
    }
}
