class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], cnt = 0;

        for(int n:nums){
            if(res==n)   cnt++;
            else{
                cnt--;
                if(cnt<0){
                    cnt = 0;
                    res=n;
                }
            }
        }
        return res;
    }
}