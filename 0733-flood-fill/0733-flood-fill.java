class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int oc, int color){
        if(sr<0||sc<0||sr>image.length-1||sc>image[0].length-1||image[sr][sc]!=oc||image[sr][sc]==color)
            return;

        image[sr][sc] = color;
        dfs(image, sr+1, sc, oc, color);
        dfs(image, sr, sc+1, oc, color);
        dfs(image, sr, sc-1, oc, color);
        dfs(image, sr-1, sc, oc, color);
    }
}