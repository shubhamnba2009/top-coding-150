class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;

        for(int n : nums) totSum +=n;
        if(totSum%2!=0) return false;

        int subSetSum = totSum / 2;
        int n = nums.length;
        Boolean[][] flag = new Boolean[n][subSetSum+1];

        return backtrack(nums, flag, n-1,  subSetSum);
    }

    private boolean backtrack(int[] nums, Boolean[][] flag, int idx, int subSetSum){
        if(subSetSum == 0) return true;
        if(subSetSum<0||idx == 0)
            return false;

        if(flag[idx][subSetSum]!=null)
            return flag[idx][subSetSum];
        boolean res =  backtrack(nums, flag, idx-1, subSetSum-nums[idx-1]) || backtrack(nums, flag, idx-1, subSetSum);
        flag[idx][subSetSum] = res;
        return flag[idx][subSetSum];
    }
}