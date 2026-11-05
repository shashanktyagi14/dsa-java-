package com.shashank.dsa.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class ArrayAlgorithms {
    private ArrayAlgorithms() {
    }

    /**
     * Returns indices of the first pair encountered whose values sum to target.
     * If no pair exists, returns {@code {-1, -1}}.
     *
     * @throws NullPointerException if nums is null
     * Time: O(n) expected; Space: O(n).
     */
    public static int[] twoSum(int[] nums, int target) {
        Objects.requireNonNull(nums, "nums");
        Map<Integer, Integer> firstIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            long needed = (long) target - nums[i];
            if (needed >= Integer.MIN_VALUE && needed <= Integer.MAX_VALUE) {
                Integer j = firstIndex.get((int) needed);
                if (j != null) {
                    return new int[]{j, i};
                }
            }
            firstIndex.putIfAbsent(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * Computes the maximum sum of a non-empty contiguous subarray.
     *
     * @throws IllegalArgumentException if nums is empty
     * @throws NullPointerException if nums is null
     * Time: O(n); Space: O(1).
     */
    public static long maximumSubarraySum(int[] nums) {
        Objects.requireNonNull(nums, "nums");
        if (nums.length == 0) {
            throw new IllegalArgumentException("nums must not be empty");
        }

        long current = nums[0];
        long best = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    /**
     * Returns inclusive prefix sums: result[i] is the sum of nums[0..i].
     * Time: O(n); Space: O(n).
     */
    public static long[] prefixSums(int[] nums) {
        Objects.requireNonNull(nums, "nums");
        long[] prefix = new long[nums.length];
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        return prefix;
    }
}
