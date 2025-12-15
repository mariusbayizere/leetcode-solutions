
import java.util.*;

/**
 * LeetCode Problem: Longest Palindromic Substring
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/longest-palindromic-substring/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Given a string `s`, return the longest palindromic substring
 * contained within `s`.
 *
 * A palindrome is a string that reads the same forward and backward.
 *
 * ---------------------------------------------------------
 * 📝 Example 1:
 * Input:  s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * 📝 Example 2:
 * Input:  s = "cbbd"
 * Output: "bb"
 *
 * ---------------------------------------------------------
 * 🔍 Approach: Expand Around Center
 * ---------------------------------------------------------
 * Every palindrome has a center.
 * We consider two possible centers for each index:
 *
 * 1️⃣ Odd-length palindromes
 *    - Center at one character (e.g., "aba")
 *
 * 2️⃣ Even-length palindromes
 *    - Center between two characters (e.g., "bb")
 *
 * For each index:
 * - Expand outward while characters on both sides are equal.
 * - Track the longest palindrome found so far.
 *
 * Why this works:
 * - We efficiently check all possible palindrome centers.
 * - Avoids unnecessary substring checks.
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n²)
 * - For each character, expansion may take up to O(n).
 *
 * 🧠 Space Complexity: O(1)
 * - Uses constant extra space (excluding output substring).
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String ans = "";

        for(int i = 0; i < s.length(); i++) {
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }
            if(ans.length() < r - l - 1) ans = s.substring(l + 1, r);

            l = i;
            r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }
            if(ans.length() < r - l - 1) ans = s.substring(l + 1, r);
        }
        return ans;
    }
}

/**
 * ---------------------------------------------------------
 * 🧪 Main Class — Testing longestPalindrome()
 * ---------------------------------------------------------
 */
class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(solution.longestPalindrome("babad"));
        // Expected: "bab" or "aba"

        // Test Case 2
        System.out.println(solution.longestPalindrome("cbbd"));
        // Expected: "bb"

        // Test Case 3
        System.out.println(solution.longestPalindrome("a"));
        // Expected: "a"

        // Test Case 4
        System.out.println(solution.longestPalindrome("ac"));
        // Expected: "a" or "c"

        // Test Case 5
        System.out.println(solution.longestPalindrome("forgeeksskeegfor"));
        // Expected: "geeksskeeg"
    }
}