class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>>res = new ArrayList<>();
        List<Integer>ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        //baerr min
        for(int i=0;i<arr.length-1;i++){
            minDiff = Math.min(minDiff, Math.abs(arr[i]-arr[i+1]));
        }
        
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i]-arr[i+1]) == minDiff){
                ans.add(arr[i]);
                ans.add(arr[i+1]);
                res.add(ans);
                ans = new ArrayList<>();
            }
        }

        return res;
    }
}