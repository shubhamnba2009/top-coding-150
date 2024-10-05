class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;

        while(low<=high){
            int mid = (low+high)>>>1;

            if(nums[mid] == target)
                return mid;
            else if(nums[mid]>=nums[low]){
                if(nums[mid]>=target&&target>=nums[low])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else{
                if(nums[mid]<=target&&nums[high]>=target)
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }
}