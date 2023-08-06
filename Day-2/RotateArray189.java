class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int start = nums.length-k;
        int end = nums.length-1;
        swap(nums,start,end);
        start = 0;
        end = nums.length-k-1;
        swap(nums,start,end);
        swap(nums,0,nums.length-1);
    }
    void swap(int[] nums, int st, int end)
    {
        while(st<end)
        {
            int tmp = nums[st];
            nums[st++] = nums[end];
            nums[end--] = tmp;
        }
    }
}
