class Solution {
    public int maxProfit(int[] prices) {
        int maxP = Integer.MIN_VALUE;
        int buyP = prices[0];
        for(int p:prices){
            buyP = Math.min(buyP, p);
            maxP = Math.max(maxP, p-buyP);
        }
        return maxP;
    }
}