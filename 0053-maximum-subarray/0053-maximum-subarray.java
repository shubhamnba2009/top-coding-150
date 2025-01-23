class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;

        int cnt = 0;
        while(cnt<nums.length){
            while(curSum>=0&&cnt<nums.length){
                curSum += nums[cnt++];
                maxSum = Math.max(maxSum, curSum);
            }
            curSum = 0;
        }

        return maxSum;
    }
}