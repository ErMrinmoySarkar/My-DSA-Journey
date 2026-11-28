class Solution {
    private int helper(int[] nums, int st, int end, int target){
        if(st>end) return -1;
        int mid = st+(end-st)/2;
        if(nums[mid] == target) return mid;
        if(nums[st] <= nums[mid]){ // case 1 
            if(nums[st] <= target && target <= nums[mid]) return helper(nums,st,mid-1,target);
            else return helper(nums,mid+1,end,target);
        }else{ //case 2
            if(nums[mid] <= target && target <= nums[end]) return helper(nums,mid+1,end,target);
            else return helper(nums,st,mid-1,target);
        }
    }
    public int search(int[] nums, int target) {
        return helper(nums,0, nums.length-1,target); //divide & conqure
    }
}