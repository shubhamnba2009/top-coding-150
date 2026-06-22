class Solution {
    public int maxProfit(int[] prices) {
        int curBuy = prices[0];
        int maxp = Integer.MIN_VALUE;

        for(int price: prices){
            curBuy = Math.min(curBuy, price);
            maxp = Math.max(maxp, price-curBuy);
        }

        return maxp;
    }
}