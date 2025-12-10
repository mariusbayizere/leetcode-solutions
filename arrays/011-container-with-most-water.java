import  java.lang.*;

/**
 * LeetCode Problem: Container With Most Water
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/container-with-most-water/
 *
 * Problem Summary:
 * Given an array height[] where each index represents a vertical line of that height,
 * find two lines that together with the x-axis form a container that holds the
 * maximum amount of water.
 *
 * You must return the maximum possible area.
 *
 * Example:
 * Input:  height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation:
 * Choosing lines at index 1 (height 8) and index 8 (height 7),
 * width = 8 - 1 = 7,
 * min height = 7 → area = 7 * 7 = 49.
 *
 *
 * ---------------------------------------------------------
 * 🔍 Approach: Two-Pointer Technique
 * ---------------------------------------------------------
 * - Initialize one pointer at the left end and the other at the right end.
 * - At each step:
 *     • Compute area between left and right.
 *     • Update maximum area if needed.
 *     • Move the pointer pointing to the shorter height inward.
 *
 * Why this works:
 * - The area is limited by the shorter height.
 * - Moving the taller line inward never improves the area.
 *
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n)
 * Reason: Each pointer moves at most once.
 *
 * 🧠 Space Complexity: O(1)
 * Reason: Only constant variables are used.
 *
 */
class Solution{
    public int maxArea(int[] height){
        int right = height.length - 1;
        int left = 0;
        int maximum_amountOf_water = 0;

        while (left < right){
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            maximum_amountOf_water = Math.max(maximum_amountOf_water, currentWater);

            if (height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return  maximum_amountOf_water;
    }
}


class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: [1,8,6,2,5,4,8,3,7] → Output: 49
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // Output: 49

        // Example 2: [1,1] → Output: 1
        System.out.println(solution.maxArea(new int[]{1, 1})); // Output: 1
    }
}