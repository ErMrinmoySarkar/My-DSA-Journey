class Solution {
    static void helper(int[] nums, List<Integer>subset,List<List<Integer>>ans,int idx){
        if(idx==nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }
        //include
        subset.add(nums[idx]);
        helper(nums,subset,ans,idx+1);
        //exlude
        subset.remove(subset.size()-1);
        helper(nums,subset,ans,idx+1);
    } 
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>subset = new ArrayList<>();
        helper(nums,subset,ans,0);

        return ans;
    }
}