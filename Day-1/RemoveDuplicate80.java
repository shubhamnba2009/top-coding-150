class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int flag = 0;

        for(int i = 1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1]&&flag<1)
            {
                nums[cnt++] = nums[i];
                flag++;
            }
            if(nums[i]!=nums[i-1])
            {
                nums[cnt++] = nums[i];
                flag=0;
            }
        }
        return cnt;
    }
}