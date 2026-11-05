package com.shashank.dsa.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class SlidingWindow {
    private SlidingWindow() {
    }

    /**
     * Returns the maximum sum among all contiguous windows of exactly k elements.
     *
     * @throws IllegalArgumentException unless 1 <= k <= nums.length
     * Time: O(n); Space: O(1).
     */
    public static long maximumWindowSum(int[] nums, int k) {
        Objects.requireNonNull(nums, "nums");
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException("k must be between 1 and nums.length");
        }

        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        long best = windowSum;

        for (int right = k; right < nums.length; right++) {
            windowSum += nums[right] - (long) nums[right - k];
            best = Math.max(best, windowSum);
        }
        return best;
    }

    /**
     * Returns the longest contiguous subarray containing at most k distinct values.
     * For k == 0 the result is zero.
     *
     * @throws IllegalArgumentException if k is negative
     * Time: O(n) expected; Space: O(min(n, k)).
     */
    public static int longestSubarrayAtMostKDistinct(int[] nums, int k) {
        Objects.requireNonNull(nums, "nums");
        if (k < 0) {
            throw new IllegalArgumentException("k must be non-negative");
        }
        if (k == 0 || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < nums.length; right++) {
            frequency.merge(nums[right], 1, Integer::sum);

            while (frequency.size() > k) {
                int value = nums[left++];
                int count = frequency.get(value) - 1;
                if (count == 0) {
                    frequency.remove(value);
                } else {
                    frequency.put(value, count);
                }
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
