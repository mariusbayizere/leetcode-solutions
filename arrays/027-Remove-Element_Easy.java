import java.util.*;

/**
 * LeetCode Problem: Remove Element
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-element/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Given an integer array `nums` and an integer `val`, remove all occurrences
 * of `val` in-place and return the number of elements that are NOT equal to `val`.
 *
 * Requirements:
 * - Modify the array in-place.
 * - Let k = number of elements not equal to `val`.
 * - The first `k` elements of nums should contain these non-val elements.
 * - Everything after index `k - 1` does NOT matter.
 *
 * ---------------------------------------------------------
 * 📝 Example 1:
 * Input:  nums = [3,2,2,3], val = 3
 * Output: k = 2, nums = [2,2,_,_]
 *
 * 📝 Example 2:
 * Input:  nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: k = 5, nums = [0,1,4,0,3,_,_,_]
 *
 *
 * ---------------------------------------------------------
 * 🔍 Approach: Two-Pointer Technique
 * ---------------------------------------------------------
 * - Pointer `i` scans every element in the array.
 * - Pointer `k` marks the position to place the next valid (non-val) element.
 *
 * Algorithm:
 * 1. Loop through the array:
 *        - If nums[i] == val → skip it
 *        - Else write nums[i] into nums[k], then increment k
 *
 * Why this works:
 * - We simply overwrite positions with valid numbers.
 * - Order does not matter.
 * - Everything after index k - 1 can be ignored.
 *
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n)
 * We scan the array once.
 *
 * 🧠 Space Complexity: O(1)
 * Only constant extra variables used.
 */
class Solution {
    public int removeElement(int[] nums, int val) {
        int counterElement = 0;
        for (int x = 0; x < nums.length; x++){
            if (nums[x] == val){
                continue;
            }
            else{
                nums[counterElement] = nums[x];
                counterElement = counterElement + 1;
            }
        }
        return counterElement;
    }
}


/**
 * ---------------------------------------------------------
 * 🧪 Main Class — Testing removeElement()
 * ---------------------------------------------------------
 */
class Main1 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test Case 1
        int[] nums1 = {3, 2, 2, 3};
        int k1 = solution.removeElement(nums1, 3);
        System.out.println("k = " + k1 + ", nums = " + Arrays.toString(nums1));

        // Test Case 2
        int[] nums2 = {0,1,2,2,3,0,4,2};
        int k2 = solution.removeElement(nums2, 2);
        System.out.println("k = " + k2 + ", nums = " + Arrays.toString(nums2));

        // Test Case 3 (no occurrences)
        int[] nums3 = {1, 2, 3, 4};
        int k3 = solution.removeElement(nums3, 9);
        System.out.println("k = " + k3 + ", nums = " + Arrays.toString(nums3));

        // Test Case 4 (all elements are val)
        int[] nums4 = {5, 5, 5, 5};
        int k4 = solution.removeElement(nums4, 5);
        System.out.println("k = " + k4 + ", nums = " + Arrays.toString(nums4));

        // Test Case 5 (empty array)
        int[] nums5 = {};
        int k5 = solution.removeElement(nums5, 0);
        System.out.println("k = " + k5 + ", nums = " + Arrays.toString(nums5));
    }
}