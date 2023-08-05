class Solution {
    public int removeElement(int[] nums, int val) {
        int cnt = 0;

        for(int i:nums)
        {
            if(i!=val)
                nums[cnt++] = i;
        }
        return cnt;
    }
}
