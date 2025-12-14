import java.util.*;

/**
 * LeetCode Problem: Reverse Integer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reverse-integer/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Given a signed 32-bit integer `x`, reverse its digits.
 *
 * If reversing `x` causes the value to overflow outside
 * the 32-bit signed integer range:
 *
 *      [-2^31, 2^31 - 1]
 *
 * then return 0.
 *
 * ---------------------------------------------------------
 * 📝 Example 1:
 * Input:  x = 123
 * Output: 321
 *
 * 📝 Example 2:
 * Input:  x = -123
 * Output: -321
 *
 * 📝 Example 3:
 * Input:  x = 120
 * Output: 21
 *
 * ---------------------------------------------------------
 * 🔍 Approach:
 * ---------------------------------------------------------
 * - Extract the last digit using modulus (% 10).
 * - Build the reversed number by multiplying the current
 *   result by 10 and adding the digit.
 * - Remove the last digit from x using division (/ 10).
 *
 * - Before finalizing the result, check for overflow:
 *      If the reversed value goes beyond Integer limits,
 *      return 0 immediately.
 *
 * Note:
 * - A `long` variable is used temporarily to safely detect overflow.
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n)
 * - n is the number of digits in x.
 *
 * 🧠 Space Complexity: O(1)
 * - Uses constant extra space.
 */
class Solution {

    public int reverse(int x) {
        long  Result = 0;

        while(x != 0){
            int rem = x % 10;
            Result = Result * 10 + rem;
            x = x / 10;

            if(Result > Integer.MAX_VALUE || Result < Integer.MIN_VALUE){
                return 0;
            }

        }
        return (int) Result ;

    }
}

/**
 * ---------------------------------------------------------
 * 🧪 Main Class — Testing reverse()
 * ---------------------------------------------------------
 */
class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(solution.reverse(123));   // Expected: 321

        // Test Case 2
        System.out.println(solution.reverse(-123));  // Expected: -321

        // Test Case 3
        System.out.println(solution.reverse(120));   // Expected: 21

        // Test Case 4 (Overflow)
        System.out.println(solution.reverse(1534236469)); // Expected: 0
    }
}
