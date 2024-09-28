class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0) continue;
                int minVal = m*n;
                if(i>0) minVal = Math.min(mat[i-1][j], minVal);
                if(j>0) minVal = Math.min(mat[i][j-1], minVal);
                mat[i][j] = 1 + minVal;
            }
        }
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                if(mat[i][j] == 0) continue;
                int minVal = m*n;
                if(i<m-1) minVal = Math.min(mat[i+1][j], minVal);
                if(j<n-1) minVal = Math.min(mat[i][j+1], minVal);
                mat[i][j] = Math.min(mat[i][j], 1+minVal);
            }
        }
        return mat;
    }
}