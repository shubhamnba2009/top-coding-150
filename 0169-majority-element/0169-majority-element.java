class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0], cnt = 0;

        for(int n:nums){
            if(n==res) cnt++;
            else{
                cnt--;
                if(cnt<0){res = n; cnt = 0;}
            }
        }
        return res;
    }
}