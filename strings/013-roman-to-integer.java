
/**
 * LeetCode Problem: Roman to Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/roman-to-integer/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Roman numerals are represented by seven symbols:
 *  I(1), V(5), X(10), L(50), C(100), D(500), M(1000)
 *
 * Normally, numbers are formed by adding values.
 * But in special "subtractive" cases, a smaller value before a larger one means subtraction.
 * Example:
 * - IV = 4  (5 - 1)
 * - IX = 9  (10 - 1)
 * - XL = 40 (50 - 10)
 *
 * Given a Roman numeral string `s`, convert it into an integer.
 *
 *
 * ---------------------------------------------------------
 * 🔍 Approach: Traverse From Right to Left
 * ---------------------------------------------------------
 * - Start from the last character (largest significant position).
 * - Convert each symbol into its numeric value using a switch-case.
 * - Compare the current value with the previous (right-side) value:
 *
 *     • If current < previous → subtract
 *     • Else → add
 *
 * - Update the result and continue moving left.
 *
 * Why this works:
 * - Roman numerals only use subtraction when a smaller symbol appears BEFORE a larger symbol.
 * - By scanning from right to left, you always know whether to add or subtract.
 *
 *
 * ---------------------------------------------------------
 * Example:
 * Input:  "MCMXCIV"
 * Steps:
 *   M(1000) → add → 1000
 *   C(100) < M(1000) → subtract → 900
 *   M(1000) > C(100) → add → 1900
 *   X(10) < C(100) → subtract → 1890
 *   C(100) > X(10) → add → 1990
 *   I(1) < V(5) → subtract → 1989
 *   V(5) > I(1) → add → 1994
 *
 * Output: 1994
 *
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n)
 * Reason: One pass over the string.
 *
 * 🧠 Space Complexity: O(1)
 * Reason: Only constant extra variables used.
 */
class Solution{
    int Result, currentNumber, comparedNumber;
    public int romanToInt(String s) {
     for (int x = s.length() - 1 ; x >= 0; x--){
         switch (s.charAt(x)){
             case 'M' -> currentNumber = 1000;
             case 'D' -> currentNumber = 500;
             case 'C' -> currentNumber = 100;
             case 'L' -> currentNumber = 50;
             case 'X' -> currentNumber = 10;
             case 'V' -> currentNumber = 5;
             case 'I' -> currentNumber = 1;
         }
         if (currentNumber < comparedNumber){
             Result = Result - currentNumber;
         }
         else {
             Result = Result + currentNumber;
         }
         comparedNumber = currentNumber;
     }
     return  Result;
    }
}

class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        String s1 = "III";
        System.out.println("Input: " + s1 + " → Output: " + solution.romanToInt(s1));
        // Output: 3

        // Test Case 2
        String s2 = "LVIII";
        System.out.println("Input: " + s2 + " → Output: " + solution.romanToInt(s2));
        // Output: 58

        // Test Case 3
        String s3 = "MCMXCIV";
        System.out.println("Input: " + s3 + " → Output: " + solution.romanToInt(s3));
        // Output: 1994
    }
}