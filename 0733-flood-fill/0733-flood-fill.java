class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr,sc, color, image[sr][sc]);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int target){
        if(sr<0||sc<0||sr>(image.length-1)||sc>(image[0].length-1)||image[sr][sc]!=target||image[sr][sc]==color)
            return;
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,target);
        dfs(image,sr,sc+1,color,target);
        dfs(image,sr-1,sc,color,target);
        dfs(image,sr,sc-1,color,target);
        return;
    }
}