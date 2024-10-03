class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

        int ROWS = grid.length, COLS = grid[0].length;
        int freshOranges = 0;

        for(int i = 0;i<ROWS;i++){
            for(int j =0;j<COLS;j++){
                if(grid[i][j]==2) queue.offer(new Pair(i,j));
                else if (grid[i][j]==1) freshOranges++;
            }
        }
        queue.offer(new Pair(-1,-1));
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        int time = -1;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> p = queue.poll();
            int row = p.getKey();
            int col = p.getValue();

            if(row==-1){
                time++;
                if(!queue.isEmpty()){
                    queue.offer(new Pair(-1,-1));
                }
            }
            else{
                for(int[] dir:direction){
                    int nRow = row+dir[0];
                    int nCol = col+dir[1];
                    if(nRow>=0&&nRow<ROWS&&
                    nCol>=0&&nCol<COLS){
                        if(grid[nRow][nCol]==1){
                            grid[nRow][nCol] = 2;
                            freshOranges--;
                            queue.offer(new Pair(nRow, nCol));
                        }
                    }
                }
            }
        }
        return freshOranges==0?time:-1;
    }
}