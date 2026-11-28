class Solution {
    public void sortColors(int[] nums) {
        //countSort
        int color[] = new int[3]; //O(1)
        for(int i=0;i<nums.length;i++){ //(n)
            color[nums[i]]++; //freq++ in array
        }

        int idx =0;
        for(int i=0;i<3;i++){
            while(color[i]>0){
                nums[idx++] = i;
                color[i]--;
            }
        }
        
    }
}