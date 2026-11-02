package medium;

// Time = O(n^2)   ,   Space = O(1)
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[i][j];
                matrix[i][j]=temp;
                temp=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[i][j];
                matrix[i][j]=temp;
                temp=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }
}
