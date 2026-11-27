class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] fact = new int[budget+1];
        int min = Integer.MAX_VALUE;

        for(int[] item : items){
            int factor = item[0];
            int price = item[1];

            min = Math.min(min, price);

            int rewardCount = 0;
            for(int[]factArr : items ){
                if(factArr[0] % factor == 0) rewardCount++;
            }

            for(int j=budget; j>=price; j--){
                fact[j] = Math.max(fact[j], fact[j - price] + rewardCount); 
            }
        }

        int ans = 0;
        for(int j=0; j<= budget; j++){
            ans = Math.max(ans, fact[j] + (budget - j ) / min);
        }

        return ans;
    }
}