/*
Given an integer x, return true if x is a palindrome, and false otherwise.


Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 

Constraints:

    -231 <= x <= 231 - 1

 
Follow up: Could you solve it without converting the integer to a string?
*/

/*

// String Solution

 class Solution {
    public boolean isPalindrome(int x) {
        String y = Integer.toString(x);

        int r = y.length() - 1;
        for(int l = 0; l <= r; l ++){
            if(y.charAt(l) != y.charAt(r)){
                return false;
            }
            r--;
        }
        return true;
    }

}

// Divider Solution

class Solution {
    public boolean isPalindrome(int x) {
        // Return false if x is negative
        if(x < 0){
            return false;
        }

        // Calculate divider
        int div = 1;
        while(x/div >= 10){
            div = div * 10;
        }

        while(x > 0){
            // Determine rightmost and leftmost values
            int right_value = x % 10;
            int left_value = x / div;

            // Check equality
            if(right_value != left_value){
                return false;
            }

            // Update x to remove leftmost and rightmost values
            x = x % div;
            x = x / 10;

            // Update divider value
            div = div / 100;
        }
        return true;
    }

}

*/

// Reversal Solution

class Solution {
    public boolean isPalindrome(int x) {
        int number = x;
        int reverse_number = 0;

        if(number < 0){
            return false;
        }

        while(number > 0){
            reverse_number = reverse_number * 10 + number % 10;
            number = number / 10;
        }
        return reverse_number == x;
    }

}
