package com.shashank.dsa.stack;

import java.util.Objects;

public final class MonotonicStack {
    private MonotonicStack() {
    }

    /**
     * For each position, returns the first strictly greater value to its right
     * in the circular array, or -1 if no such value exists.
     *
     * Time: O(n); Space: O(n).
     */
    public static int[] nextGreaterElementsCircular(int[] nums) {
        Objects.requireNonNull(nums, "nums");
        int n = nums.length;
        int[] answer = new int[n];
        java.util.Arrays.fill(answer, -1);
        if (n == 0) {
            return answer;
        }

        int[] stack = new int[n];
        int top = -1;
        for (int i = 0; i < 2 * n; i++) {
            int value = nums[i % n];
            while (top >= 0 && nums[stack[top] % n] < value) {
                int index = stack[top--];
                answer[index] = value;
            }
            if (i < n) {
                stack[++top] = i;
            }
        }
        return answer;
    }
}
