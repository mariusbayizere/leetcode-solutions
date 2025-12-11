import  java.util.Arrays;
/**
 * LeetCode Problem: Longest Common Prefix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/longest-common-prefix/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Given an array of strings `strs`, return the *longest common prefix*
 * shared among all the strings.
 *
 * If there is no common prefix, return "".
 *
 * ---------------------------------------------------------
 * 📝 Exampl888888888888888e 1:
 * Input:  ["flower", "flow", "flight"]
 * Output: "fl"
 *
 * 📝 Example 2:
 * Input:  ["dog", "racecar", "car"]
 * Output: ""
 * Explanation:
 * No string shares a common prefix → return empty string.
 *
 *
 * ---------------------------------------------------------
 * 🔍 Approach: Sorting + Comparing First and Last Strings
 * ---------------------------------------------------------
 * Key Insight:
 * - When the array is sorted alphabetically:
 *       → The most different strings are the **first** and **last**.
 * - Therefore, the longest common prefix of the whole array must be
 *   the prefix shared between strs[0] and strs[last].
 *
 * Steps:
 *  1. Sort the array.
 *  2. Compare the first and last strings character-by-character.
 *  3. Count how many initial characters match.
 *  4. Return the matching prefix.
 *
 * Why this works:
 * - Sorting groups similar prefixes closer together.
 * - The smallest and largest strings define the maximum possible prefix.
 *
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n log n + m)
 *   - n log n → sorting strings
 *   - m → comparing two strings
 *
 * 🧠 Space Complexity: O(1)
 *   - No extra space besides variables.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String string1 = strs[0];
        String string2 = strs[strs.length - 1];
        int i = 0;
        while (i < string1.length() && i < string2.length()){
            if (string1.charAt(i) == string2.charAt(i)){
                i++;
            }
            else{
                break;
            }
        }
        return string1.substring(0, i);
    }
}


/**
 * ---------------------------------------------------------
 * 🧪 Main Class for Testing
 * ---------------------------------------------------------
 */
class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Input: " + Arrays.toString(strs1) +
                " → Output: " + solution.longestCommonPrefix(strs1));

        // Test Case 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Input: " + Arrays.toString(strs2) +
                " → Output: " + solution.longestCommonPrefix(strs2));

        // Test Case 3
        String[] strs3 = {"interview", "internet", "internal"};
        System.out.println("Input: " + Arrays.toString(strs3) +
                " → Output: " + solution.longestCommonPrefix(strs3));

        // Test Case 4 (Edge Case: Only one string)
        String[] strs4 = {"hello"};
        System.out.println("Input: " + Arrays.toString(strs4) +
                " → Output: " + solution.longestCommonPrefix(strs4));
    }
}





