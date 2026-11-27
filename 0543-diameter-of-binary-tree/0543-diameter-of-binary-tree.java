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
    static class Info{
        int diam;
        int ht;
        Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info helper(TreeNode root){
        if(root == null) return new Info(0,0);

        Info left = helper(root.left);
        Info right = helper(root.right);

        //self
        int diam = Math.max(Math.max(left.diam,right.diam),left.ht+right.ht);
        int ht = Math.max(left.ht ,right.ht) +1;

        return new Info(diam,ht);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diam;
    }
}