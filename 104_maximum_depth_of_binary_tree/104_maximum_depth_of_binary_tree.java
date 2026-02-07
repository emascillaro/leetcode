/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:

Input: root = [1,null,2]
Output: 2

 

Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
*/

class Solution {
    public int maxDepth(TreeNode root) {

        // Base case: return null if a node has no children
        if (root == null){
            return 0;
        }

        // Recursively calculate left then right depth
        int left_depth = maxDepth(root.left);
        int right_depth = maxDepth(root.right);

        return 1 + Math.max(left_depth, right_depth);



    }
}
