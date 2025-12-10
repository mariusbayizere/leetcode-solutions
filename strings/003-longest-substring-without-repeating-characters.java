import  java.util.*;

/**
 * Finds the length of the longest substring without repeating characters in the given string.
 * This implementation uses a sliding window approach with a List to track unique characters.
 *
 * @param s The input string to be processed
 * @return The length of the longest substring without repeating characters
 * @throws NullPointerException if the input string is null
 *
 * Time Complexity: O(n), where n is the length of the input string
 * Space Complexity: O(min(m, n)), where m is the size of the character set and n is the string length
 *
 * Example:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The longest substring without repeating characters is "abc", with length 3.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max_length = 0;
        List<Character> listOf_character = new ArrayList<Character>();

        while(end < s.length()) {
            if (!listOf_character.contains(s.charAt(end))){
                listOf_character.add(s.charAt(end));
                end++;
                max_length = Math.max(max_length, listOf_character.size());
            }
            else{
                listOf_character.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return max_length;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
        String input = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(input));

//        The answer is "b", with the length of 1.
        String input1 = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(input1));

        String input2 = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(input2));

    }
}