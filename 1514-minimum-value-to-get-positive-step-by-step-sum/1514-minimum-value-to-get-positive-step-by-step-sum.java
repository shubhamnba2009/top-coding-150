class Solution {
    public int minStartValue(int[] nums) {
        int minVal = 0;
        int prefixSum = 0;
        for(int n:nums){
            prefixSum += n;
            minVal = Math.min(minVal, prefixSum);
        }

        return -minVal+1;
    }
}