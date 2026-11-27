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
    //private int helper(TreeNode root, int height){
    //     if(root==null) return 0;
    //     Queue<TreeNode>q = new LinkedList<>();
    //     q.add(root);
    //     q.add(null);
    //     while(!q.isEmpty()){
    //         TreeNode currNode = q.remove();
    //         if(currNode == null){
    //             height++;
    //             if(q.isEmpty()) break;
    //             else q.add(null);
    //         }else{
    //             if(currNode.left != null) q.add(currNode.left);
    //             if(currNode.right != null) q.add(currNode.right);
    //         }
    //     }
    //     return height;
    // }
    public int maxDepth(TreeNode root) {
        // int height =0;
        // return helper(root,height);
        // 

        //2 approach
        if(root == null) return 0;

        int htLeft = maxDepth(root.left);
        int htRight = maxDepth(root.right);
        return Math.max(htLeft,htRight)+1;
    }
}