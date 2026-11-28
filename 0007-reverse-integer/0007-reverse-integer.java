class Solution {
    public int reverse(int x) {
        boolean isNegative = false;
        //if -ve
        if(x<0){
            isNegative = true;
            x = -x;
        }

        int rev =0;
        while(x>0){
            int reminder = x % 10;
            x /= 10;

            if(rev > (Integer.MAX_VALUE - reminder) / 10) return 0;
            rev = (rev * 10) + reminder;
            
        }
        return isNegative ? -rev : rev;
    }
}