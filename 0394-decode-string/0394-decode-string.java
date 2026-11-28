class Solution {
    public String decode(String s, int[] idx){
        StringBuilder res = new StringBuilder();
        int num=0;
        while(idx[0]< s.length()){
            char ch = s.charAt(idx[0]);
            if(Character.isDigit(ch)) num = num*10 +(ch-'0');
            else if(ch=='['){ //skip
                idx[0]++;
                String decode = decode(s,idx);

                for(int j=0;j<num;j++){
                    res.append(decode);
                }
                num=0;
            }
            else if(ch==']') return res.toString();
            else res.append(ch);

            idx[0]++;
        }
        return res.toString();
    }
    public String decodeString(String s) {
        int index[]={0};
        return decode(s,index);
    }
}