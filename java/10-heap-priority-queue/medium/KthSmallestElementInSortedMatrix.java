package medium;

import java.util.PriorityQueue;
// Time = O((n+k)*log(n))   ,   Space = O(n)
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b)->{
            int i1=matrix[a[0]][a[1]];
            int i2=matrix[b[0]][b[1]];
            return Integer.compare(i1,i2);
        });
        for(int i=0; i<matrix.length;i++)   min.offer(new int[]{i,0});
        int[] pair = new int[] {0,0};
        while(!min.isEmpty()  &&  k>0){
            pair = min.poll();
            if (pair[1] + 1 < matrix[0].length)   min.offer(new int[]{pair[0], pair[1] + 1});
            k--;
        }
        return matrix[pair[0]][pair[1]];
    }
}
