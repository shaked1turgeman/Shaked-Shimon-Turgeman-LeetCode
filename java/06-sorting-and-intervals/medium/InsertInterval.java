// Time = Space = O(n)
import java.util.Arrays;
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] matrix = new int[intervals.length + 1][2];
        int count = 0, i=0, n=intervals.length; 
        while(i<n&&intervals[i][1] < newInterval[0]){
            matrix[count][0]=intervals[i][0];
            matrix[count][1]=intervals[i][1];
            count++;    i++;
        }
        while(i<n&&intervals[i][1]>=newInterval[0]&&intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        matrix[count][0]=newInterval[0];
        matrix[count][1]=newInterval[1];
        count++;
        while(i<n){
            matrix[count][0]=intervals[i][0];
            matrix[count][1]=intervals[i][1];
            count++;    i++;
        }
        int[][] result = Arrays.copyOf(matrix, count);
        return result;
    }
}
