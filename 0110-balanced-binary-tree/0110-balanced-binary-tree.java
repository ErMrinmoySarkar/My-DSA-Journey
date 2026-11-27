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
    static boolean isBalance = true;
    public int helper(TreeNode root){
        if(root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);
        if(Math.abs(l-r)>1) isBalance = false;

        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        isBalance = true;
        helper(root);

        return isBalance;
    }
}