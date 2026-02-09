/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

 

Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false

 

Constraints:

    The number of nodes in both trees is in the range [0, 100].
    -104 <= Node.val <= 104


*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Base case 1: Nodes at both trees are null
        if (p == null && q == null){
            return true;
        }

        // Base case 2: Node at one tree is null and other is not
        if (p == null || q == null){  // do not have to specify xor due to prev if statement
            return false;
        }

        // Base case 3: Nodes are not equal
        if (p.val != q.val){
            return false;
        }

        // Recursive case: Node values are equal
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }
}
