class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        // int minDiff = Integer.MAX_VALUE; //O(N^2)
        // for(int i=0;i<nums.size()-x;i++){
        //     for(int j=i+x;j<nums.size();j++){
        //         minDiff = Math.min(minDiff,(Math.abs(nums.get(i)-nums.get(j))));
        //     }
        // }

        // return minDiff;

        int minDiff = Integer.MAX_VALUE;
        TreeSet<Integer>s = new TreeSet<>();
        for(int i=x;i<nums.size();i++){
            s.add(nums.get(i-x));
            Integer high = s.ceiling(nums.get(i)), low = s.floor(nums.get(i));
            if(high != null) minDiff = Math.min(minDiff,Math.abs(nums.get(i)-high));
            if(low != null) minDiff = Math.min(minDiff,Math.abs(nums.get(i)-low)); 
        }
        return minDiff;

    }
}