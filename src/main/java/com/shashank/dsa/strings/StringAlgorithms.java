package com.shashank.dsa.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class StringAlgorithms {
    private StringAlgorithms() {
    }

    /**
     * Returns the length, in Unicode code points, of the longest substring
     * without repeated code points.
     *
     * Time: O(n) expected; Space: O(min(n, alphabet size)).
     */
    public static int longestSubstringWithoutRepeating(String value) {
        Objects.requireNonNull(value, "value");
        int[] codePoints = value.codePoints().toArray();
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int left = 0;
        int best = 0;

        for (int right = 0; right < codePoints.length; right++) {
            Integer previous = lastSeen.put(codePoints[right], right);
            if (previous != null && previous >= left) {
                left = previous + 1;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }

    /**
     * Checks whether a string is a palindrome, ignoring non-letter/digit
     * code points and comparing case-insensitively.
     * Time: O(n); Space: O(1) auxiliary (apart from UTF-16 traversal).
     */
    public static boolean isAlphanumericPalindrome(String value) {
        Objects.requireNonNull(value, "value");
        int left = 0;
        int right = value.length();

        while (left < right) {
            int leftCodePoint = value.codePointAt(left);
            if (!Character.isLetterOrDigit(leftCodePoint)) {
                left += Character.charCount(leftCodePoint);
                continue;
            }

            int rightCodePoint = value.codePointBefore(right);
            if (!Character.isLetterOrDigit(rightCodePoint)) {
                right -= Character.charCount(rightCodePoint);
                continue;
            }

            if (Character.toLowerCase(leftCodePoint) != Character.toLowerCase(rightCodePoint)) {
                return false;
            }
            left += Character.charCount(leftCodePoint);
            right -= Character.charCount(rightCodePoint);
        }
        return true;
    }
}
