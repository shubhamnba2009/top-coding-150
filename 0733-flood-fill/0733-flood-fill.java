class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int nc, int oo) {
        if(sc>=image[0].length||sr>=image.length||sr<0||sc<0||image[sr][sc]==nc||image[sr][sc]!=oo)
            return;
        image[sr][sc] = nc;
        dfs(image, sr+1, sc, nc, oo);
        dfs(image, sr-1, sc, nc, oo);
        dfs(image, sr, sc+1, nc, oo);
        dfs(image, sr, sc-1, nc, oo);
    }
}