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
    public String helper(TreeNode curr, HashMap<String,Integer>map,List<TreeNode>ans){
        if(curr == null) return "-";

        String left = helper(curr.left,map,ans);
        String right = helper(curr.right,map,ans);

        String str = Integer.toString(curr.val) + "#" + left + "#" + right;
        if(map.containsKey(str)){
            if(map.get(str) == 1) ans.add(curr);
            map.put(str,map.get(str)+1);
        }else map.put(str,1);

        return str;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>result = new ArrayList<>();
        HashMap<String,Integer>map = new HashMap<>();
        helper(root,map,result);

        return result;
    }
}