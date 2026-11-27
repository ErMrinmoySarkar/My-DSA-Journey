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
    static int ans = 0;
    public void dfs(TreeNode curr, int level){
        if(curr == null) return;

        if(curr.left == null && curr.right == null){
            ans = Math.min(ans, level);
            return;
        }
        dfs(curr.left, level+1);
        dfs(curr.right, level+1);
    }
    public int minDepth(TreeNode root) {
        if(root == null) return 0; //base case
        ans = Integer.MAX_VALUE;
        dfs(root,1);

        return ans;
    }
}