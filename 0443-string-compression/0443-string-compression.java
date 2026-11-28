class Solution {
    public int compress(char[] chars) {
        int i=0, rest =0;
        while(i<chars.length){
            int count = 1;
            while(i + count < chars.length && chars[i + count] == chars[i]){
                count++;
            }

            chars[rest++] = chars[i];
            if(count>1){
                for(char ch : Integer.toString(count).toCharArray()){
                    chars[rest++] = ch;
                }
            }
            i += count;
        }
        return rest;
    }
}