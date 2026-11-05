package com.shashank.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArrayAlgorithmsTest {
    @Test
    void twoSumHandlesDuplicatesAndMissingPairs() {
        assertArrayEquals(new int[]{0, 1}, ArrayAlgorithms.twoSum(new int[]{3, 3, 8}, 6));
        assertArrayEquals(new int[]{-1, -1}, ArrayAlgorithms.twoSum(new int[]{1, 2, 3}, 10));
    }

    @Test
    void twoSumDoesNotOverflowWhileFindingComplement() {
        assertArrayEquals(new int[]{0, 1},
                ArrayAlgorithms.twoSum(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, -1));
    }

    @Test
    void maximumSubarrayWorksWithNegativeValues() {
        assertEquals(-2L, ArrayAlgorithms.maximumSubarraySum(new int[]{-8, -2, -5}));
        assertEquals(6L, ArrayAlgorithms.maximumSubarraySum(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    @Test
    void prefixSumsUseLongValues() {
        assertArrayEquals(new long[]{Integer.MAX_VALUE, 2L * Integer.MAX_VALUE},
                ArrayAlgorithms.prefixSums(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }

    @Test
    void maximumSubarrayRejectsEmptyInput() {
        assertThrows(IllegalArgumentException.class,
                () -> ArrayAlgorithms.maximumSubarraySum(new int[0]));
    }
}
