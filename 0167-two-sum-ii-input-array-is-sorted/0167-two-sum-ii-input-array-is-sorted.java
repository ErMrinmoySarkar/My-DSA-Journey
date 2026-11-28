class Solution {
    public int[] twoSum(int[] nums, int target) {
        int st = 0, end = nums.length-1;
        while(st<=end){
            if(nums[st]+nums[end] == target) return new int[]{st+1,end+1};

            else if(nums[st]+nums[end] < target) st++;
            else end--; 
        }
        return new int[]{};
    }
}