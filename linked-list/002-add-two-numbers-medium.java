/**
 * LeetCode Problem: Add Two Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/add-two-numbers/
 *
 * Problem Description:
 * Given two non-empty linked lists representing two non-negative integers,
 * where the digits are stored in reverse order and each node contains a single digit,
 * add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zeros, except the number 0 itself.
 *
 * Examples:
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Approach:
 * - Create a dummy head for the result linked list.
 * - Use a pointer to build the result list and a carry variable for sums >= 10.
 * - Traverse both linked lists simultaneously:
 *   - Add the current digits from both lists along with the carry.
 *   - Update carry = sum / 10 and store sum % 10 in a new node.
 *   - Move the pointer and input list nodes forward.
 * - After the loop, if carry is 1, add a new node with value 1.
 * - Return dummy.next as the head of the resulting linked list.
 *
 * Time Complexity: O(max(m, n)) where m and n are the lengths of the input lists.
 * Space Complexity: O(max(m, n)) for the resulting linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode pointer = result;

        int carry = 0;
        int sum = 0;

        while (l1 != null || l2 != null) {
            sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            sum = sum % 10;
            pointer.next = new ListNode(sum);
            pointer = pointer.next;
        }

        if (carry == 1) {
            pointer.next = new ListNode(1);
        }

        return result.next;
    }
}

class Test {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Manually create first linked list: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Manually create second linked list: 5 -> 6 -> 4
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Add the two numbers
        ListNode result = sol.addTwoNumbers(l1, l2);

        // Print the result linked list
        while (result != null) {
            System.out.print(result.val);
            if (result.next != null) System.out.print(" -> ");
            result = result.next;
        }
        System.out.println(); // Expected output: 7 -> 0 -> 8
    }
}
