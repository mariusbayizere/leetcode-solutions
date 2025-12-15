import java.util.*;

/**
 * LeetCode Problem: Zigzag Conversion
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/zigzag-conversion/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Given a string `s` and an integer `numRows`, write the string
 * in a zigzag pattern across `numRows` rows and then read it
 * row by row.
 *
 * The zigzag pattern goes:
 *   - Vertically down the rows
 *   - Then diagonally up to the top
 *   - Repeat until all characters are placed
 *
 * ---------------------------------------------------------
 * 📝 Example 1:
 * Input:  s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 *
 * Pattern:
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * ---------------------------------------------------------
 * 📝 Example 2:
 * Input:  s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 *
 * Pattern:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * ---------------------------------------------------------
 * 📝 Example 3:
 * Input:  s = "A", numRows = 1
 * Output: "A"
 *
 * ---------------------------------------------------------
 * 🔍 Approach:
 * ---------------------------------------------------------
 * - If numRows == 1, the zigzag pattern does not change the string.
 *
 * - Create an array of StringBuffers, one for each row.
 *
 * - Traverse the string while:
 *      1. Moving DOWN the rows (top → bottom)
 *      2. Then moving UP diagonally (bottom → top)
 *
 * - Append each character to the appropriate row.
 *
 * - Finally, combine all rows into one result string.
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n)
 * - Each character is processed exactly once.
 *
 * 🧠 Space Complexity: O(n)
 * - Extra space used to store characters in rows.
 */
class Solution {

    int i,x,k;
    public String convert(String s, int numRows) {

        i = 0; x = 0; k = 0;
        if (numRows == 1) {
            return s;
        }
        int n = s.length();
        StringBuffer [] arr = new StringBuffer[numRows];
        for(; k<numRows; k++) arr[k] = new StringBuffer();

        while(i<n){
            for(; x<numRows && i<n;){
                arr[x].append(s.charAt(i++));
                x++;
            }
            for(x=numRows-2; x>0 && i<n;){
                arr[x].append(s.charAt(i++));
                x--;
            }
        }
        StringBuffer obj = new StringBuffer();
        for(StringBuffer el : arr){
            obj.append(el);
        }
        return obj.toString();
    }
}

/**
 * ---------------------------------------------------------
 * 🧪 Main Class — Testing Zigzag Conversion
 * ---------------------------------------------------------
 */
class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        System.out.println(
                solution.convert("PAYPALISHIRING", 3)
        ); // Expected: PAHNAPLSIIGYIR

        // Test Case 2
        System.out.println(
                solution.convert("PAYPALISHIRING", 4)
        ); // Expected: PINALSIGYAHRPI

        // Test Case 3
        System.out.println(
                solution.convert("A", 1)
        ); // Expected: A
    }
}