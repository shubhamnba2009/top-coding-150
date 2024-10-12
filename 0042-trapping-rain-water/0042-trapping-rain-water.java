class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int maxh = Integer.MIN_VALUE;
        for(int i = 0;i<height.length;i++){
            maxh = Math.max(maxh, height[i]);
            left[i] = maxh;
        }
        maxh = Integer.MIN_VALUE;
        for(int i = height.length-1;i>=0;i--){
            maxh = Math.max(maxh, height[i]);
            right[i] = maxh;
        }

        int res = 0;

        for(int i = 0;i<height.length;i++){
            res = res+Math.min(left[i], right[i])-height[i];
        }
        return res;
    }
}