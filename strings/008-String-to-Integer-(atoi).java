import java.util.*;

/**
 * LeetCode Problem: String to Integer (atoi)
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Implement the function myAtoi(String s) that converts a
 * string into a 32-bit signed integer.
 *
 * The conversion follows these rules:
 *
 * 1️⃣ Whitespace:
 *    - Ignore any leading whitespace characters.
 *
 * 2️⃣ Signedness:
 *    - If the first non-whitespace character is '-' → negative.
 *    - If it is '+' → positive.
 *    - Otherwise, assume positive.
 *
 * 3️⃣ Conversion:
 *    - Read characters while they are digits ('0' to '9').
 *    - Stop once a non-digit character is encountered.
 *    - If no digits are read, return 0.
 *
 * 4️⃣ Overflow Handling:
 *    - If the integer exceeds the 32-bit signed integer range
 *      [-2^31, 2^31 - 1], clamp the value:
 *          • Return Integer.MAX_VALUE for overflow
 *          • Return Integer.MIN_VALUE for underflow
 *
 * ---------------------------------------------------------
 * 📝 Example 1:
 * Input:  s = "42"
 * Output: 42
 *
 * 📝 Example 2:
 * Input:  s = " -042"
 * Output: -42
 *
 * 📝 Example 3:
 * Input:  s = "1337c0d3"
 * Output: 1337
 *
 * 📝 Example 4:
 * Input:  s = "0-1"
 * Output: 0
 *
 * 📝 Example 5:
 * Input:  s = "words and 987"
 * Output: 0
 *
 * ---------------------------------------------------------
 * 🔍 Approach:
 * ---------------------------------------------------------
 * - Trim leading whitespace.
 * - Determine sign (+ or -).
 * - Convert characters to digits until a non-digit appears.
 * - Detect overflow BEFORE adding a new digit.
 * - Return the final integer with the correct sign.
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n)
 * - n is the length of the string.
 *
 * 🧠 Space Complexity: O(1)
 * - Uses only constant extra space.
 */

class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int ans = 0, i = 0;
        boolean neg = s.charAt(0) == '-';
        boolean pos = s.charAt(0) == '+';

        if (neg || pos) {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + digit;
            i++;
        }

        return neg ? -ans : ans;
    }
}


/**
 * ---------------------------------------------------------
 * 🧪 Main Class — Testing myAtoi()
 * ---------------------------------------------------------
 */
class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(solution.myAtoi("42")); // Expected: 42

        // Test Case 2
        System.out.println(solution.myAtoi(" -042")); // Expected: -42

        // Test Case 3
        System.out.println(solution.myAtoi("1337c0d3")); // Expected: 1337

        // Test Case 4
        System.out.println(solution.myAtoi("0-1")); // Expected: 0

        // Test Case 5
        System.out.println(solution.myAtoi("words and 987")); // Expected: 0

        // Test Case 6 (Overflow)
        System.out.println(solution.myAtoi("91283472332")); // Expected: 2147483647
    }
}