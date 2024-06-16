/*
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.
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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return goodNodesRec(root, max); 
    }
    private int goodNodesRec(TreeNode root, int max){
        if(root == null) return 0;
        if(root.val >= max){
            return 1+goodNodesRec(root.left, root.val)+goodNodesRec(root.right, root.val);
        }
        return goodNodesRec(root.left, max)+goodNodesRec(root.right, max);
    }
}