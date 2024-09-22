class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;

        int right = 0, currSum = 0;

        while(right<nums.length){
            while(currSum >=0&&right<nums.length){
                currSum += nums[right++];
                res = Math.max(currSum, res);
            }
            currSum = 0;
        }
        return res;
    }
}