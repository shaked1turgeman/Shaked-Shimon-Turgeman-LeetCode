package medium;

import java.util.ArrayList;
import java.util.List;

// Time = O(m*n)   ,   Space = O(m*n) for output
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, left = 0, bottom = matrix.length - 1, right = matrix[0].length - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= bottom){
            for(int i=left; i<=right; i++) res.add(matrix[top][i]);
            top++;
            for(int i =top; i<=bottom; i++) res.add(matrix[i][right]);
            right--;
            if(top <= bottom)
                for(int i=right; i>=left; i--)  res.add(matrix[bottom][i]);
            bottom--;
            if(left <= right)
                for(int i=bottom; i>=top; i--)  res.add(matrix[i][left]);
            left++;
        }
        return res;
    }
}
