class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int max = 0;

        for(int i = 0;i<height.length; i++){
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = 0;
        for(int i = height.length-1;i>=0; i--){
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        int res = 0;

        for(int i = 0;i<height.length;i++){
            res+=Math.min(left[i], right[i]) - height[i];
        }

        return res;
    }
}