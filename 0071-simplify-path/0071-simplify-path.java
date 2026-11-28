class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String>s = new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(!s.isEmpty() && arr[i].equals("..")) s.pop();
            else if(arr[i].equals(".")== false && arr[i].equals("") == false && arr[i].equals("..") == false){
                s.push(arr[i]);
            }
        }
        if(s.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for(String curr:s){
            sb.append("/");
            sb.append(curr);
        }

        return sb.toString();
    }
}