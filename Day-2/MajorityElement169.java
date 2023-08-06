class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for(int a:nums)
        {
            if(a!=candidate)
            {
                count--;
                if(count==0)
                {
                    candidate=a;
                    count++;
                }
            }
            else
                count++;
        }
        return candidate;
    }
}