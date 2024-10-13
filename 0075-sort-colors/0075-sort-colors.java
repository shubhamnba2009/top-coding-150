class Solution {
    public void sortColors(int[] nums) {
        int start  = 0, end = nums.length-1, curr = 0;

        while(curr<=end){
            if(nums[curr] == 0){
                swap(nums, curr, start);
                start++;curr++;
            } else if(nums[curr] == 2){
                swap(nums,curr, end);
                end--;
            } else {
                curr++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}