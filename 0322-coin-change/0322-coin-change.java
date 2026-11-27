class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];     
        Arrays.fill(minCoins,amount+1);
        minCoins[0] = 0;
        for(int curr =1;curr<=amount;curr++){
            for(int j=0;j<coins.length;j++){
                if(curr - coins[j] >=0){
                    minCoins[curr] = Math.min(minCoins[curr],1+minCoins[curr-coins[j]]);
                }
            }
        }

        return minCoins[amount] != amount+1 ? minCoins[amount] : -1;
    }
}