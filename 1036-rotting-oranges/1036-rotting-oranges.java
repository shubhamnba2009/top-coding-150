class Solution {
    public int orangesRotting(int[][] grid) {
        int ROW = grid.length, COL = grid[0].length, freshOranges = 0;

        Queue<int[]> q = new ArrayDeque<>();
        int[][] vis = new int[ROW][COL];

        for(int i = 0;i<ROW;i++){
            for(int j =0;j<COL;j++){
                if(grid[i][j]==2){
                    vis[i][j] = 2;
                    q.add(new int[]{i,j,0});
                }   else if(grid[i][j]==1) {
                    freshOranges++;
                }
            }
        }
        int cnt = 0, time = 0;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            int t = q.peek()[2];
            time = Math.max(time, t);
            q.poll();
            int[][] dir = {{1,0,},{-1,0},{0,1},{0,-1}};

            for(int[] d:dir){
                int nr = r+d[0];
                int nc = c+d[1];

                if(nr>=0&&nc>=0&&nr<ROW&&nc<COL&&grid[nr][nc]==1&&vis[nr][nc]!=2){
                    vis[nr][nc] = 2;
                    q.add(new int[]{nr, nc, t+1});
                    cnt++;
                }
            }
        }

        return cnt==freshOranges?time:-1;

    }
}