package com.shashank.dsa.heaps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HeapAlgorithmsTest {
    @Test
    void kthLargestCountsDuplicatesAndDoesNotMutateInput() {
        int[] values = {3, 2, 1, 5, 6, 4, 5};
        int[] original = values.clone();
        assertEquals(5, HeapAlgorithms.kthLargest(values, 2));
        assertEquals(6, HeapAlgorithms.kthLargest(values, 1));
        org.junit.jupiter.api.Assertions.assertArrayEquals(original, values);
    }

    @Test
    void kthLargestValidatesK() {
        assertThrows(IllegalArgumentException.class,
                () -> HeapAlgorithms.kthLargest(new int[]{1, 2}, 0));
        assertThrows(IllegalArgumentException.class,
                () -> HeapAlgorithms.kthLargest(new int[]{1, 2}, 3));
    }
}
