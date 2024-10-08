class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], currSum = 0;

        for(int n:nums){
            currSum+=n;
            res = Math.max(res, currSum);
            if(currSum<0)
                currSum = 0;
        }
        return res;
    }
}