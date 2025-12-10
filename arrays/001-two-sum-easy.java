import java.util.Arrays;

/**
 * LeetCode Problem 1: Two Sum
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 *
 * Problem Description:
 * Given an array of integers 'nums' and an integer 'target', return indices of the two numbers
 * such that they add up to target. You may assume that each input would have exactly one solution,
 * and you may not use the same element twice. You can return the answer in any order.
 *
 * Approach:
 * - Brute-force method: Check each pair of elements in the array.
 * - Use two nested loops:
 *   - Outer loop: Pick the first element.
 *   - Inner loop: Pick the second element and check if the sum equals the target.
 * - If the sum matches, store the indices in the result array and return it.
 *
 * Time Complexity: O(n^2) - because we check every pair of elements.
 * Space Complexity: O(1) - only a fixed-size array of length 2 is used.
 */
class Solution {

    /**
     * Finds two indices such that nums[i] + nums[j] == target
     * @param nums - input array of integers
     * @param target - the target sum
     * @return int[] - array containing the indices of the two elements
     */
    public int[] twoSum(int[] nums, int target) {

        // Initialize the result array to store the indices
        int[] result = new int[2];

        // Loop through each element as the first number
        for (int i = 0; i < nums.length - 1; i++) {

            // Loop through the remaining elements as the second number
            for (int j = i + 1; j < nums.length; j++) {

                // Check if the sum matches the target
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result; // Return immediately once solution is found
                }
            }
        }

        // Return the result array (though problem guarantees exactly one solution)
        return result;
    }
}


class  Test {
    /**
     * Main method to test the twoSum function
     */
    public static void main(String[] args) {

        Solution solution = new Solution();

        // Test case 1
        int[] result1 = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Test case 1 result: " + Arrays.toString(result1)); // Expected: [0, 1]

        // Test case 2
        int[] result2 = solution.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println("Test case 2 result: " + Arrays.toString(result2)); // Expected: [1, 2]

        // Test case 3
        int[] result3 = solution.twoSum(new int[]{3, 3}, 6);
        System.out.println("Test case 3 result: " + Arrays.toString(result3)); // Expected: [0, 1]
    }
}
