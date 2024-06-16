/*
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
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
    private int SumChecker(TreeNode root, int currSum, int targetSum){
       if(root == null) return 0;
       int count = 0;
       if(root.val+currSum == targetSum){
         count++;
       }
       count += SumChecker(root.left, root.val+currSum, targetSum);
       count += SumChecker(root.right, root.val+currSum, targetSum); 
       return count; 
    }
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if(root == null) return 0;
        count = SumChecker(root,0, targetSum);
        return count + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
}