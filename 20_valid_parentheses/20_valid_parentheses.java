/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false

Example 4:

Input: s = "([])"
Output: true

Example 5:

Input: s = "([)]"
Output: false

Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.


*/

import java.util.HashMap;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Stack to track open parentheses
        Stack<Character> openParentheses = new Stack<>();

        // Hashmap to pair open and close parentheses
        HashMap<Character, Character> pairParentheses = new HashMap<Character, Character>();

        pairParentheses.put(')', '(');
        pairParentheses.put(']', '[');
        pairParentheses.put('}', '{');

        // Iterate through string

        for(int i = 0; i < s.length(); i++){
            // If open parentehses, add to stack
            if(pairParentheses.containsValue(s.charAt(i))){
                openParentheses.push(s.charAt(i));
            }
            // If close parentheses and stack is not empty
            else if(!openParentheses.isEmpty() && pairParentheses.get(s.charAt(i)) == openParentheses.peek()){
                openParentheses.pop();
            }
            else{
                return false;
            }
        }
        return openParentheses.empty();
    }
}
