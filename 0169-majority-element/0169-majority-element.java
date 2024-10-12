class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, res = nums[0];

        for(int n:nums){
            if(res==n) cnt++;
            else{
                cnt--;
                if(cnt<0) {res = n;cnt = 0;}
            }
        }
        return res;
    }
}