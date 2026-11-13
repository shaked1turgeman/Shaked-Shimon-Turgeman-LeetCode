// Time = O(n^2)   ,   Space = O(n)
public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length, sum=0;
        int[] minDist = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        for (int i = 0; i < points.length; i++) {
                int min = Integer.MAX_VALUE, mini = -1;
                for (int h = 0; h < n; h++) 
                    {if (!visited[h] && minDist[h] < min) {min = minDist[h];  mini = h;}}
                visited[mini]=true;
                sum += minDist[mini];
                for(int j=0; j < points.length; j++){
                    if(!visited[j]){
                        int distx = Math.abs(points[mini][0] - points[j][0]);
                        int disty = Math.abs(points[mini][1] - points[j][1]);
                        minDist[j] = Math.min(minDist[j], distx + disty);  
                    }
                }
        }
        return sum;
    }
}
