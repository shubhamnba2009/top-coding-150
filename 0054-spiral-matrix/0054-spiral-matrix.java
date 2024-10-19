class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        spiral(matrix, m, n, 0, -1, 0, 1, res);
        return res;
    }

    public void spiral(int[][] matrix, int m, int n, int r, int c, int dr, int dc, List<Integer> res){
        if(m == 0|| n==0)   return;

        for(int i = 0;i<n;i++){
            r = r+dr;
            c = c+dc;
            res.add(matrix[r][c]);
        }
        spiral(matrix, n, m-1, r, c, dc, -dr, res);
    }
}