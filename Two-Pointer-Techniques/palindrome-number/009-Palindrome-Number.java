/**
 * LeetCode Problem: Palindrome Number
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/palindrome-number/
 *
 * Problem Description:
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * A palindrome reads the same forward and backward.
 *
 * Notes:
 * - Negative numbers are NOT palindrome because of the '-' sign.
 * - No extra space conversion to string is needed; solve using arithmetic.
 *
 * Examples:
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reversed is still 121.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: -121 becomes 121-, which is not the same.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: 10 reversed becomes 01, which is not equal to 10.
 *
 * Approach:
 * - If x < 0, return false immediately.
 * - Reverse the integer by extracting digits using modulus and division.
 * - Compare the reversed number with the original.
 *
 * Time Complexity: O(log10(n))
 * Reason: Each loop removes one digit from x.
 *
 * Space Complexity: O(1)
 * Reason: Uses constant variables only.
 */
class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers cannot be palindromes
        if (x < 0) {
            return false;
        }

        int reversedNumber = 0;
        int temp = x;

        // Reverse the integer
        while (x > 0) {
            reversedNumber = (reversedNumber * 10) + (x % 10);
            x = x / 10;
        }

        // Check if the reversed number matches the original
        return reversedNumber == temp;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: 121 → true
        System.out.println(solution.isPalindrome(121)); // Output: true

        // Example 2: -121 → false
        System.out.println(solution.isPalindrome(-121)); // Output: false

        // Example 3: 10 → false
        System.out.println(solution.isPalindrome(10)); // Output: false
    }
}