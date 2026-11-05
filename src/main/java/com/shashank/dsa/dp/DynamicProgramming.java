package com.shashank.dsa.dp;

import java.util.Arrays;
import java.util.Objects;

public final class DynamicProgramming {
    private DynamicProgramming() {
    }

    /**
     * Returns the fewest coins needed to make amount, or -1 when impossible.
     * Each denomination may be used any number of times.
     *
     * @throws IllegalArgumentException for a negative amount or non-positive coin
     * Time: O(amount * numberOfCoins); Space: O(amount).
     */
    public static int minimumCoins(int[] coins, int amount) {
        Objects.requireNonNull(coins, "coins");
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        for (int coin : coins) {
            if (coin <= 0) {
                throw new IllegalArgumentException("coin denominations must be positive");
            }
        }
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }

        int unreachable = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, unreachable);
        dp[0] = 0;

        for (int value = 1; value <= amount; value++) {
            for (int coin : coins) {
                if (coin <= value && dp[value - coin] != unreachable) {
                    dp[value] = Math.min(dp[value], dp[value - coin] + 1);
                }
            }
        }
        return dp[amount] == unreachable ? -1 : dp[amount];
    }

    /**
     * Returns the length of a longest strictly increasing subsequence.
     * Uses patience sorting with binary search.
     * Time: O(n log n); Space: O(n).
     */
    public static int longestIncreasingSubsequenceLength(int[] nums) {
        Objects.requireNonNull(nums, "nums");
        int[] tails = new int[nums.length];
        int length = 0;

        for (int value : nums) {
            int left = 0;
            int right = length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (tails[mid] < value) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            tails[left] = value;
            if (left == length) {
                length++;
            }
        }
        return length;
    }
}
