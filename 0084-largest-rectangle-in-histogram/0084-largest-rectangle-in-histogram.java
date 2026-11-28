class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer>s = new Stack<>(); //index store
        int nsr[] = new int[n];
        for(int i=n-1;i>=0;i--){ 
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.isEmpty()) nsr[i] = n;
            else nsr[i] = s.peek();

            s.push(i);
        }

        s = new Stack<>();
        int[] nsl = new int[n];
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) s.pop();
            if(s.isEmpty()) nsl[i] = -1;
            else nsl[i] = s.peek();

            s.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int ht = heights[i];
            int width = nsr[i] - nsl[i] -1;
            maxArea = Math.max(maxArea,(ht*width));
        }
        return maxArea;
    }
}