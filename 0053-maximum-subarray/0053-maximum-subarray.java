class Solution {
    public int maxSubArray(int[] nums) {
        int resSum = 0, maxSum = Integer.MIN_VALUE;

        for(int n:nums){
            resSum+=n;
            maxSum = Math.max(resSum, maxSum);
            if(resSum<0) resSum = 0;
        }
        return maxSum;
    }
}