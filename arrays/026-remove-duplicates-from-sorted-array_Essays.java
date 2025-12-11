import java.util.*;

/**
 * LeetCode Problem: Remove Duplicates from Sorted Array
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * ---------------------------------------------------------
 * 📌 Problem Summary:
 * ---------------------------------------------------------
 * Given a sorted integer array `nums`, remove duplicates **in-place** such that
 * each unique value appears only once.
 *
 * Requirements:
 * - Modify the array in-place.
 * - Return the number of unique elements `k`.
 * - The first `k` elements of `nums` must contain the unique values in order.
 * - Everything after index `k - 1` can be ignored.
 *
 * ---------------------------------------------------------
 * 📝 Example 1:
 * Input:  nums = [1,1,2]
 * Output: k = 2, nums = [1,2,_]
 *
 * 📝 Example 2:
 * Input:  nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: k = 5, nums = [0,1,2,3,4,_,_,_,_,_]
 *
 *
 * ---------------------------------------------------------
 * 🔍 Approach: Two-Pointer Technique
 * ---------------------------------------------------------
 * - Pointer `k` tracks the index where the next unique number should be placed.
 * - Loop through the array:
 *      • Whenever nums[x] != nums[x-1], we found a new unique number.
 *      • Place it at nums[k] and increment k.
 *
 * Why this works:
 * - The array is already sorted.
 * - Therefore, duplicates are always consecutive.
 * - Every unique number appears the first time when nums[x] != nums[x-1].
 *
 *
 * ---------------------------------------------------------
 * ⏱ Time Complexity: O(n)
 * Reason:
 * - We scan the array once.
 *
 * 🧠 Space Complexity: O(1)
 * Reason:
 * - Only constant extra variables used.
 */
class Solutions{
    public int removeDuplicates(int[] nums){
        int k = 1;
        for (int x = 1; x < nums.length; x++){
            if(nums[x] != nums[x - 1]){
                nums[k] = nums[x];
                k++;
            }
        }
        return  k;
    }
}


/**
 * ---------------------------------------------------------
 * 🧪 Main Class — Testing removeDuplicates()
 * ---------------------------------------------------------
 */
class Main {
    public static void main(String[] args) {

        Solutions solution = new Solutions();

        // Test Case 1
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println("k = " + k1 + ", nums = " + Arrays.toString(nums1));

        // Test Case 2
        int[] nums2 = {0,0,1,1,1,2,2,3,3,4};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println("k = " + k2 + ", nums = " + Arrays.toString(nums2));

        // Test Case 3 (All unique)
        int[] nums3 = {1, 2, 3, 4, 5};
        int k3 = solution.removeDuplicates(nums3);
        System.out.println("k = " + k3 + ", nums = " + Arrays.toString(nums3));

        // Test Case 4 (All duplicates)
        int[] nums4 = {7, 7, 7, 7};
        int k4 = solution.removeDuplicates(nums4);
        System.out.println("k = " + k4 + ", nums = " + Arrays.toString(nums4));
    }
}