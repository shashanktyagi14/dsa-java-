package com.shashank.dsa.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MonotonicStackTest {
    @Test
    void nextGreaterElementsWrapAround() {
        assertArrayEquals(new int[]{2, -1, 2},
                MonotonicStack.nextGreaterElementsCircular(new int[]{1, 2, 1}));
        assertArrayEquals(new int[]{-1, -1, -1},
                MonotonicStack.nextGreaterElementsCircular(new int[]{3, 3, 3}));
        assertArrayEquals(new int[0],
                MonotonicStack.nextGreaterElementsCircular(new int[0]));
    }
}
