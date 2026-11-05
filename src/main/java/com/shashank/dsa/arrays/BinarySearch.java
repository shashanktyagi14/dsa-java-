package com.shashank.dsa.arrays;

import java.util.Objects;

public final class BinarySearch {
    private BinarySearch() {
    }

    /**
     * Returns the first index i for which sorted[i] >= target.
     * The input must be sorted in non-decreasing order.
     * Time: O(log n); Space: O(1).
     */
    public static int lowerBound(int[] sorted, int target) {
        Objects.requireNonNull(sorted, "sorted");
        int left = 0;
        int right = sorted.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * Returns the first occurrence of target, or -1 when absent.
     * The input must be sorted in non-decreasing order.
     * Time: O(log n); Space: O(1).
     */
    public static int firstOccurrence(int[] sorted, int target) {
        int index = lowerBound(sorted, target);
        return index < sorted.length && sorted[index] == target ? index : -1;
    }
}
