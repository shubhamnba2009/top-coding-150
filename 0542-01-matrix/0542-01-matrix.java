class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length, c = mat[0].length;

        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                int minVal = r*c;
                if(mat[i][j] == 0) continue;

                if(i>0)    minVal = Math.min(minVal, mat[i-1][j]);
                if(j>0)    minVal = Math.min(minVal, mat[i][j-1]);

                mat[i][j] = 1+minVal;
            }
        }

        for(int i = r-1;i>=0;i--){
            for(int j = c-1;j>=0;j--){
                int minVal = r*c;
                if(mat[i][j] == 0) continue;

                if(i<r-1)    minVal = Math.min(minVal, mat[i+1][j]);
                if(j<c-1)    minVal = Math.min(minVal, mat[i][j+1]);

                mat[i][j] = Math.min(mat[i][j], 1+minVal);
            }
        }

        return mat;
    }
}