/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 * 
 * 
 * 
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
    public int maxLevelSum(TreeNode root) {
       int max = Integer.MIN_VALUE;
       int ans = 0, level = 0;
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       q.add(root);
       while(!q.isEmpty()){
        int size = q.size();
        int sum = 0;
        level++;
        for(int i=0;i<size;i++){
            TreeNode node = q.poll();
            sum+=node.val;
            if(node.left!=null) q.add(node.left);
            if(node.right!=null) q.add(node.right);
        }
        if(sum > max){
            max = sum;
            ans = level;
        }
       }
       return ans; 
    }
}