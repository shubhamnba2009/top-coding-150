class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];

        return dpHelper(coins, amount);
    }

    public int dpHelper(int[] coins, int amount){
        if(amount==0)
            return 0;
        if(amount<0)
            return -1;
        if(memo[amount] != 0)
            return memo[amount];

        int minAmt = Integer.MAX_VALUE;

        for(int coin:coins){
            int amt = dpHelper(coins, amount-coin);
            if(amt == -1) continue;
            minAmt = Math.min(minAmt, 1+amt);
        }

        memo[amount] = minAmt == Integer.MAX_VALUE?-1: minAmt;
        return memo[amount];
        
        }
}