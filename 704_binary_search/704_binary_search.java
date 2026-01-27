/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

 Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

 

Constraints:

    1 <= nums.length <= 104
    -104 < nums[i], target < 104
    All the integers in nums are unique.
    nums is sorted in ascending order.


*/


class Solution {
    public int search(int[] nums, int target) {

        // Initialize left and right pointers at start and end of array
        int left = 0;
        int right = nums.length - 1;

        // Search until pointers cross
        while (left <= right){

            // Set center to middle of potential target area of array
            int center = left + (right - left)/2;

            // Return center index if target is found
            if (nums[center] == target){
                return center;
            }
            
            // Shift left pointer if target is greater than center
            else if (nums[center] < target){
                left = center + 1;
            }

            // Shift right pointer if target is less than center
            else {
                right = center - 1;
            }
        }

        // Return target not found if left and right pointers cross
        return -1;
        
    }
}
