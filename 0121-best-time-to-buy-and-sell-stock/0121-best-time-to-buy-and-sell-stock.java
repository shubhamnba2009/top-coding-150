class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0], maxP = 0;

        for(int p:prices){
            buy = Math.min(buy, p);
            maxP = Math.max(maxP, p-buy);
        }
        return maxP;
    }
}