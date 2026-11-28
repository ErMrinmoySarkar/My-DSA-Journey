class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 1){
            List<Integer> singleList = new ArrayList<>();
            singleList.add(nums[0]);
            res.add(singleList);
            return res;
        }

        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            int[] newArray = new int[nums.length-1];
            int idx  =0;
            for(int j=0;j<nums.length;j++){
                if(j != i) newArray[idx++] = nums[j];
            }

            List<List<Integer>>perms = permute(newArray);
            for(List<Integer>p:perms){
                p.add(val);
            }

            res.addAll(perms);
        }
        return res;
    }
}