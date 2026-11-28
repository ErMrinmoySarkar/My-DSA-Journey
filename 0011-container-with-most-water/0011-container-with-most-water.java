class Solution {
    public int maxArea(int[] height) {
        int maxWaterArea = Integer.MIN_VALUE;
        int st=0,end = height.length-1;
        while(st<end){
            int ht = Math.min(height[st],height[end]);
            int width = end-st;
            maxWaterArea = Math.max((ht*width),maxWaterArea);

            if(height[st]<height[end]) st++;
            else end--;
        }

        return maxWaterArea;
    }
}