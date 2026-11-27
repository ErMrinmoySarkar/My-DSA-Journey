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
    private void storeData(TreeNode root, List<Integer>sortArr){
        if(root == null) return;

        storeData(root.left,sortArr);
        sortArr.add(root.val);
        storeData(root.right,sortArr);
    }

    private TreeNode createBST(List<Integer>sortArr, int st, int end){
        if(st>end) return null;

        int mid = (st+end)/2;
        TreeNode root = new TreeNode(sortArr.get(mid));
        root.left = createBST(sortArr,st,mid-1);
        root.right = createBST(sortArr,mid+1,end);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>sortArr = new ArrayList<>();
        storeData(root,sortArr); 

        return createBST(sortArr,0,sortArr.size()-1);
    }
}