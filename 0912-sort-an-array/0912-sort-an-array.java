class Solution {
    public static void merge(int[] nums, int st, int mid, int end){
        int[] temp = new int[end-st+1];
        int i= st, j = mid+1, idx = 0;

        while(i<=mid && j<=end){
            if(nums[i] < nums[j]) temp[idx++] = nums[i++];
            else temp[idx++] = nums[j++];
        }

        //left 
        while(i<=mid) temp[idx++] = nums[i++];

        //right
        while(j<=end) temp[idx++] = nums[j++];

        //copy temp to real array
        for(idx=0, i =st;idx<temp.length;idx++,i++) nums[i] = temp[idx];
    }
    public static void mergeSort(int[] nums, int st, int end){
        if(st>=end) return;
        int mid = st+(end-st)/2;
        mergeSort(nums,st,mid); //left part
        mergeSort(nums,mid+1,end); //right part

        merge(nums,st,mid,end);
    } 
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}