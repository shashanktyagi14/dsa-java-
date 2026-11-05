package com.shashank.dsa.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinarySearchTest {
    @Test
    void lowerBoundHandlesDuplicatesAndEdges() {
        int[] values = {1, 2, 2, 2, 5};
        assertEquals(1, BinarySearch.lowerBound(values, 2));
        assertEquals(4, BinarySearch.lowerBound(values, 4));
        assertEquals(0, BinarySearch.lowerBound(values, 0));
        assertEquals(values.length, BinarySearch.lowerBound(values, 9));
    }

    @Test
    void firstOccurrenceReturnsFirstDuplicate() {
        assertEquals(1, BinarySearch.firstOccurrence(new int[]{1, 2, 2, 2, 3}, 2));
        assertEquals(-1, BinarySearch.firstOccurrence(new int[]{1, 2, 3}, 4));
        assertEquals(-1, BinarySearch.firstOccurrence(new int[0], 4));
    }
}
