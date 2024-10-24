class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        spiral(matrix, res, 0, -1, 0, 1, matrix.length, matrix[0].length);

        return res;
    }

    private void spiral(int[][] matrix, List<Integer> res, int r, int c, int dr, int dc, int m, int n){
        if(m == 0 || n==0) return;

        for(int j = 0;j<n;j++){
            r = r+dr;
            c = c+dc;
            res.add(matrix[r][c]);
        }
        spiral(matrix, res, r, c, dc, -dr, n, m-1);
    }
}