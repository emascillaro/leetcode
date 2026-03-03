/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Example 3:

Input: nums = [1,0,1,2]
Output: 3

 

Constraints:

    0 <= nums.length <= 105
    -109 <= nums[i] <= 109
*/

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Create variable to store longest consecutive sequence
        int maxLength = 0;
        // Add all elements of array into a hashset
        HashSet<Integer> numSet = new HashSet<Integer>();
        for(int i : nums){
            numSet.add(i);
        }

        // Find starting elements
        for (int i : numSet){
            if (!numSet.contains(i-1)){
                int currentLength = 1;

                // Check for consecutive values
                while (numSet.contains(i+currentLength)){
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
