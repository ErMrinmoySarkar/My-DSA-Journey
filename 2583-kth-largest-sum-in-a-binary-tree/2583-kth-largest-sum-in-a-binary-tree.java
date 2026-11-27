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
    public long kthLargestLevelSum(TreeNode root, int k) {
       PriorityQueue<Long>pq = new PriorityQueue<>(
        Collections.reverseOrder()
       );

       Queue<TreeNode>bfsQ = new LinkedList<>();
       bfsQ.add(root);
       while(!bfsQ.isEmpty()){
        int size = bfsQ.size();
        long sum =0;
        for(int i=0;i<size;i++){
            TreeNode curr = bfsQ.remove();
            sum+= curr.val;
            if(curr.left != null) bfsQ.add(curr.left);
            if(curr.right != null) bfsQ.add(curr.right);
        }
        pq.add(sum);
       } 

       if(pq.size()<k) return -1;
       for(int i=0;i<k-1;i++) pq.remove();
       return pq.peek();
    }
}