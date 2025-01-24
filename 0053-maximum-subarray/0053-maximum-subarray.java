class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for(int n:nums){
            curSum += n;
            maxSum = Math.max(maxSum, curSum);
            if(curSum<0)
                curSum = 0;
        }
        return maxSum;
    }
}