class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0;i<mat.length;i++){
            for(int j = 0;j<mat[0].length;j++){
                if(mat[i][j]==0) continue;
                int minNeigh = m*n;

                if(i>0) minNeigh = Math.min(mat[i-1][j], minNeigh);
                if(j>0) minNeigh = Math.min(mat[i][j-1], minNeigh);

                mat[i][j] = minNeigh+1;
            }
        }
        for(int i = mat.length-1;i>=0;i--){
            for(int j = mat[0].length-1;j>=0;j--){
                if(mat[i][j]==0) continue;
                int minNeigh = m*n;

                if(i<mat.length-1) minNeigh = Math.min(mat[i+1][j], minNeigh);
                if(j<mat[0].length-1) minNeigh = Math.min(mat[i][j+1], minNeigh);

                mat[i][j] = Math.min(minNeigh+1, mat[i][j]);
            }
        }

        return mat;
    }
}