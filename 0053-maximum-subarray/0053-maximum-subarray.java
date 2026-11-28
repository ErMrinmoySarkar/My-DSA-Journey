class Solution {
    public int maxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE; 
        
        // Initialize max_ending_here to store the maximum sum of a subarray 
        //ending at the current position.
        int currSum = 0;

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Add the current element to max_ending_here
            currSum += arr[i];

            // If max_ending_here becomes greater than max_so_far, 
            //update max_so_far
            maxSum = Math.max(currSum,maxSum);

            // If max_ending_here becomes negative, reset it to 0.
            // This is because a negative sum will only decrease the sum of 
            //any future subarray.
            if (currSum < 0) currSum =  0;
        }
        return maxSum;
    }
}