class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i :nums)    totalSum+=i;
        if(totalSum%2!=0)   return false;
        int subSetSum = totalSum/2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n][subSetSum+1];
        return dfsHelper(nums, subSetSum, n-1, memo);
        
    }
    private boolean dfsHelper(int[] nums, int subSetSum, int idx, Boolean[][] memo){
            if(subSetSum==0)    return true;
            if(idx==0||subSetSum<0) return false;
            if(memo[idx][subSetSum]!=null) return memo[idx][subSetSum];

            boolean result = dfsHelper(nums, subSetSum-nums[idx-1], idx-1, memo) || dfsHelper(nums, subSetSum, idx-1, memo);
            memo[idx][subSetSum] = result;
            return result;
    }
}