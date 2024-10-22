class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int n : nums) totSum += n;
        if(totSum%2!=0) return false;
        int subSetSum = totSum / 2;

        boolean[] dp  = new boolean[subSetSum+1];
        dp[0] = true;
        for(int n : nums){
            for(int i = subSetSum; i>=n;i--){
                dp[i] = dp[i] || dp[i-n];
            }
        }

    return dp[subSetSum];
    }
}