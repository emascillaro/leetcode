/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

 

Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.

 */

import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest_substring_length = 0;
        int l = 0;
        
        HashSet<Character> seen_characters = new HashSet<>();

        for(int r = 0; r < s.length(); r++){
            while(seen_characters.contains((char)s.charAt(r))){
                seen_characters.remove((char)s.charAt(l));
                l++;
            }
            seen_characters.add((char)(s.charAt(r)));

            int current_substring_length = r-l+1;
            longest_substring_length = Math.max(longest_substring_length, current_substring_length);
        }
        return longest_substring_length;
    }
}
