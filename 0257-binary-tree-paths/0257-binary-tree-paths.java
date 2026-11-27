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
    private void pathStore(List<Integer>path,List<String>result){
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<path.size();i++){
            sb.append(path.get(i).toString());
            if(i<path.size()-1) sb.append("->");
        }
        result.add(sb.toString());
    }
    private void helper(TreeNode root, List<Integer>path,List<String>result){
        if(root == null) return;

        path.add(root.val);
        if(root.left == null && root.right == null){
            pathStore(path,result);
        }

        helper(root.left,path,result);
        helper(root.right,path,result);
        path.remove(path.size()-1);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result = new ArrayList<>();
        List<Integer>path = new ArrayList<>();
        helper(root,path,result);
        
        return result;
    }
}