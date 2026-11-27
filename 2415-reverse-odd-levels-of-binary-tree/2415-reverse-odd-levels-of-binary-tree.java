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
    private void solve(TreeNode L, TreeNode R, int parentVal){
        if(L == null && R == null) return;
        if(parentVal%2 != 0){
            int temp = L.val;
            L.val = R.val;
            R.val = temp;
        }
        solve(L.left,R.right,parentVal+1);
        solve(L.right,R.left,parentVal+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return null;
        //when only root here
        if (root.left == null && root.right==null) return root;
        solve(root.left,root.right,1);

        return root;
    }
}