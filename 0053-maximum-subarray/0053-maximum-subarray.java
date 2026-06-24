class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = Integer.MIN_VALUE;

        for(int n:nums){
            curSum+=n;
            maxSum = Math.max(curSum, maxSum);
            if(curSum<0){
                curSum = 0;
            }
        }
        return maxSum;
    }
}