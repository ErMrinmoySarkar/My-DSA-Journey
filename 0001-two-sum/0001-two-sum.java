class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*  ---> O(n^2)
        int[] ans = new int[2];  
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    ans[0] = i ;
                    ans[1] = j;
                    break;
                }
            }
            
        }
        return ans;*/

        Map<Integer,Integer>map = new HashMap<>(); //O(n)
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }

        return new int[] {}; //empty
    }
}