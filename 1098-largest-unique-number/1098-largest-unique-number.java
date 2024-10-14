class Solution {
    public int largestUniqueNumber(int[] nums) {
        int[] map = new int[1001];

        for(int n:nums){
            map[n]++;
        }

        int res = -1;

        for(int i = 1;i<1001;i++){
            if(map[i]==1)   res = Math.max(res, i);
        }
        return res;
    }
}