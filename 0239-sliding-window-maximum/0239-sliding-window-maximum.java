class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer>temp = new ArrayList<>();
        Deque<Integer>dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            //remove garbage
            if(!dq.isEmpty() && i-dq.peekFirst()+1 >k) dq.pollFirst();

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) dq.pollLast();
            dq.offerLast(i);

            if(i+1>=k) temp.add(nums[dq.peekFirst()]);
        }

        int[] ans = new int[temp.size()];
        for(int i=0;i<temp.size();i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }
}