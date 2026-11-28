class Solution {
    public double myPow(double x, int n) {
        if(x==1) return 1.0;
        if(x==0) return 0.0;
        if(n==0) return 1.0;
        if(n==1) return x;

        //-ve case handel
        long biForm = n;
        if(biForm<0){
            x = 1/x; //reciprocal
            biForm = -biForm; // -ve + -ve = +ve convert
        }
        double ans =1;
        while(biForm>0){
            if((biForm&1) != 0){
                ans *= x;
            }
            x *= x;
            biForm = biForm>>1; 
        }

        return ans;
    }
}