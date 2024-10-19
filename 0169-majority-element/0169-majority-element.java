class Solution {
    public int majorityElement(int[] nums) {
        int currMaj = nums[0], cnt = 0;

        for(int n:nums){
            if(currMaj == n) cnt++;
            else{
                cnt--;
                if(cnt<0){
                    currMaj = n;
                    cnt = 0;
                }
            }
        }
        return currMaj;

    }
}