package easy;

// Time = O(m*n) = Space = O(r*c) or O(1) Time and Space if we output the original matrix.
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length, n=mat[0].length;
        if (r*c!=m*n)  return mat;
        int[][] res = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0;j<c;j++){
                int index = i * c + j;
                int row = index / n;
                int col = index % n;
                res[i][j]=mat[row][col];
            }
        }
        return res;
    }
}
