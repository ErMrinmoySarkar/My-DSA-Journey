class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
        if(m==0 && n==1){
            nums1[0] = nums2[0];
        }

        for(int i=0;i<n;i++){
            nums1[m+i] = nums2[i];
        }

        Arrays.sort(nums1);*/

        int i = m-1;
        int j = n-1;
        int posi = m+n-1;
        while(j>=0){
            if(i>=0 && nums1[i] > nums2[j]){
                nums1[posi--] = nums1[i--];
            }else{
                nums1[posi--] = nums2[j--];
            }
        }
        
    }
}