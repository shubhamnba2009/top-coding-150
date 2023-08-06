class Solution {
    public int maxProfit(int[] prices) {
        int maxp=0;
        int buy = prices[0];
        int sell = prices[0];
        for(int i = 0;i<prices.length;i++)
        {
            if(prices[i]>buy)
            {
                maxp=maxp+(prices[i]-buy);
                buy = prices[i];
            }
            else
            {
                buy = prices[i];
            }
        }
        return maxp;
        
    }
}