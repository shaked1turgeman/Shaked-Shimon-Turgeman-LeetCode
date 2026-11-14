// Time = O(n^3)   ,   Space = O(n^2)
public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
            mat[i][i] = 0;
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            mat[u][v] = weight;
            mat[v][u] = weight;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (mat[i][k] != Integer.MAX_VALUE && mat[k][j] != Integer.MAX_VALUE) {
                        int newDist = mat[i][k] + mat[k][j];
                        if (newDist < mat[i][j]) {
                            mat[i][j] = newDist;
                            mat[j][i] = newDist;
                        }
                    }
                }
            }
        }
        int minCount = Integer.MAX_VALUE, ind=0;
        for (int i = 0; i < n; i++) {
            int count=0;
            for (int j = 0; j < n; j++)                    
                if (i != j && mat[i][j] <= distanceThreshold) count++;
            if(count<=minCount) {minCount=count;    ind=i;}
        }
        return ind;
    }  
}    

