class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE;
        int prof = Integer.MIN_VALUE;

        for(int p:prices){
            buy = Math.min(buy, p);
            int curp = p-buy;
            prof = Math.max(prof, curp);
        }

        return prof;
    }
}