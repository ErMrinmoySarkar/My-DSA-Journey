class Solution {
    public int[] nextGreaterElements(int[] arr) {

        int sol[] = new int[arr.length];
        Stack<Integer>s = new Stack<>();
        for(int i=2*arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i%arr.length]) s.pop();
            sol[i%arr.length] = s.isEmpty() ? -1 : arr[s.peek()];
            s.push(i%arr.length);
        }
        return sol;
        
    }
    
}