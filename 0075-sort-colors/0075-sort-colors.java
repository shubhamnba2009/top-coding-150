class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length-1, curr = 0;

        while(curr<=end){
            if(nums[curr] == 0){
                nums[curr++] = nums[start]; 
                nums[start++] = 0;
            } else if (nums[curr] == 2){
                nums[curr] = nums[end];
                nums[end--] = 2;
            } else {
                curr++;
            }
        }
    }
}