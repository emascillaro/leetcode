/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

 

Example 1:

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

 

Constraints:

    The number of nodes in the root tree is in the range [1, 2000].
    The number of nodes in the subRoot tree is in the range [1, 1000].
    -104 <= root.val <= 104
    -104 <= subRoot.val <= 104

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case 1: Return false if the tree is empty
        if (root == null){
            return false;
        }
        // Base case 2: Return true if the trees are the same
        if (sameTree(root, subRoot) == true){
            return true;
        }
        // Recursive case: Return true if left or right subtree is the same as subroot
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Check if two trees are the same using recursion
    private boolean sameTree(TreeNode root, TreeNode subRoot){
        // Base case 1: Return true if both roots are null
        if (root == null && subRoot == null){
            return true;
        }
        // Base case 2: Return false if one root is null
        if (root == null || subRoot == null){
            return false;
        }
        // Base case 3: Return false if node values are not equal
        if (root.val != subRoot.val){
            return false;
        }
        // Recursive case: Return true if values of left and right child nodes are equal
        return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}
