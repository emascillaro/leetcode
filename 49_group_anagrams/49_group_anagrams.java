/*
Given an array of strings strs, group the together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.


*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  public String getStringSignature(String str) {
    int[] count = new int[26];
    for (char c : str.toCharArray()) {
      count[c - 'a']++;
    }
    StringBuilder keyStr = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      if (count[i] != 0) {
        keyStr.append((char)('a' + i)).append(count[i]);
      }
    }
    return keyStr.toString();
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    Map<String, List<String>> groups = new HashMap<>();

    for (String str : strs) {
      groups.computeIfAbsent(getStringSignature(str), k -> new ArrayList<>())
          .add(str);
    }

    result.addAll(groups.values());
    return result;
  }
}
