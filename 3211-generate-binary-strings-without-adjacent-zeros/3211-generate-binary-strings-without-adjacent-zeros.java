class Solution {
    public static void helper(int n,List<String>result,int lastP, String ans){
        if(n==0){
            result.add(ans);
            return;
        }

        helper(n-1,result,1,ans+"1");
        if(lastP == 1) helper(n-1,result,0,ans+"0");
    }
    public List<String> validStrings(int n) {
        List<String>result = new ArrayList<>();
        helper(n,result,1,new String(""));
        return result;
    }
}