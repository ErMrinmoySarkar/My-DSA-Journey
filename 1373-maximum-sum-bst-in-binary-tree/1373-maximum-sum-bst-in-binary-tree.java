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
    class Info{
        int min;
        int max;
        int sum;
        Info(int min, int max, int sum){
            this.min = min;
            this.max = max;
            this.sum = sum;
        }
    }
    int ans =0;
    private Info helper(TreeNode root){
        if(root == null) return new Info(Integer.MAX_VALUE,Integer.MIN_VALUE,0);

        //leaf
        if(root.left == null && root.right == null){
            ans = Math.max(ans,root.val);
            return new Info(root.val,root.val,root.val);
        }

        Info leftInfo = helper(root.left);
        Info rightInfo = helper(root.right);

        //chekc bst
        if(leftInfo.max < root.val && root.val < rightInfo.min){
            int totalSum = root.val+leftInfo.sum+rightInfo.sum;
            ans = Math.max(ans,totalSum);
            return new Info(
                Math.min(leftInfo.min,root.val),
                Math.max(rightInfo.max, root.val),
                totalSum
            );
        }

        //not a bst
        return new Info(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(leftInfo.sum,rightInfo.sum));
    }
    public int maxSumBST(TreeNode root) {
        helper(root);
        return ans;
    }
}