package medium;

import java.util.PriorityQueue;
// Time = O(n*log(k))   ,   Space = O(k)
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b)->{
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];
            return Integer.compare(distB, distA);
        });
        for(int i=0; i<points.length;i++){
                max.offer(points[i]);
                if(max.size()>k)    max.poll();            
        }
        int[][] res = new int[k][2];
        for(int i =0; i<k; i++) {if(!max.isEmpty())res[i]=max.poll();}
        return res;
    }
}
