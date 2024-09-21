class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int prof = Integer.MIN_VALUE;

        for(int p:prices){
            buy = Math.min(buy, p);
            prof = Math.max(prof, p-buy);
        }

        return prof;
    }
}