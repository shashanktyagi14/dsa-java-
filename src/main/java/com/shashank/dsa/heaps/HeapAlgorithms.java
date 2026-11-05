package com.shashank.dsa.heaps;

import java.util.Objects;
import java.util.PriorityQueue;

/** Heap-based selection algorithms. */
public final class HeapAlgorithms {
    private HeapAlgorithms() {
    }

    /**
     * Returns the k-th largest value, counting duplicates as separate values.
     * The input array is not modified.
     *
     * @throws IllegalArgumentException unless 1 <= k <= nums.length
     * Time: O(n log k); Space: O(k).
     */
    public static int kthLargest(int[] nums, int k) {
        Objects.requireNonNull(nums, "nums");
        if (k < 1 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and nums.length");
        }

        PriorityQueue<Integer> smallestOfLargest = new PriorityQueue<>(k);
        for (int value : nums) {
            if (smallestOfLargest.size() < k) {
                smallestOfLargest.add(value);
            } else if (value > smallestOfLargest.peek()) {
                smallestOfLargest.remove();
                smallestOfLargest.add(value);
            }
        }
        return smallestOfLargest.element();
    }
}
