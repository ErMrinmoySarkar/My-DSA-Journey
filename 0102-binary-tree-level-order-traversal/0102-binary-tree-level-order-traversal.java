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
    private void helper(TreeNode root,List<List<Integer>>res){
        if(root == null) return;
        List<Integer>ans = new ArrayList<>();

        Queue<TreeNode>q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if(currNode==null){
                //important line
                res.add(ans);
                ans = new ArrayList<>();
                if(q.isEmpty()) return;
                else q.add(null);
            }else{
                ans.add(currNode.val);
                if(currNode.left != null) q.add(currNode.left);
                if(currNode.right != null) q.add(currNode.right);
            }
        }
        return;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        helper(root,res);
        return res;
    }
}