/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]


Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    k is in the range [1, the number of unique elements in the array].
    It is guaranteed that the answer is unique.

 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create hashmap to count occurences of each element in nums
        HashMap <Integer, Integer> occurencesHashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            occurencesHashmap.put(nums[i], occurencesHashmap.getOrDefault(nums[i], 0) + 1);
        }

        // Create frequency array
        List<Integer>[] frequenciesArray = new List[nums.length + 1];

        for (int key : occurencesHashmap.keySet()){
            int value = occurencesHashmap.get(key);
            if (frequenciesArray[value] == null){
                frequenciesArray[value] = new ArrayList<>();
            }
            frequenciesArray[value].add(key);
        }

        // Extract top k elements from frequencies array
        int[] result = new int[k];
        int position = 0;

        for (int i = frequenciesArray.length - 1; i >= 0; i--){
            if (frequenciesArray[i] != null){
                for (int j = 0; j < frequenciesArray[i].size() && position < k; j++){
                    result[position] = frequenciesArray[i].get(j);
                    position++;
                }
            }
        }
        return result;
    }
}
