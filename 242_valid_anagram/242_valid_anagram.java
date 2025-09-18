/*

Given two strings s and t, return true if t is an

of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 

Constraints:

    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.

 

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?

*/

import java.util.Arrays;

/*

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] s_counts = new int[26];
        int[] t_counts = new int[26];

        for(int i = 0; i < s.length(); i++){
            s_counts[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++){
            t_counts[t.charAt(i) - 'a']++;
        }

        return Arrays.equals(s_counts, t_counts);

    }
}

*/

class Solution {
  public boolean isAnagram(String s, String t) {

    if (s.length() != t.length()) {
      return false;
    }

    int[] s_counts = new int[26];
    int[] t_counts = new int[26];

    for (int i = 0; i < s.length(); i++) {
      s_counts[s.charAt(i) - 'a']++;
      t_counts[t.charAt(i) - 'a']++;
    }

    return Arrays.equals(s_counts, t_counts);
  }
}
