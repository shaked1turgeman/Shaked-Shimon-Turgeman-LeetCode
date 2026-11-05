// Time = O(n^2)   ,   Space = O(n)
public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = n;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {parent[i] = i;  size[i] = 1;}

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(isConnected[i][j]==1 && union(i,j,parent,size))  provinces--; 
            }
        }
        return provinces;
    }

    public boolean union(int a, int b, int[] parent, int[] size) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);
        if (rootA == rootB) return false;
        if (size[rootA] < size[rootB]) {parent[rootA]=rootB;    size[rootB]+=size[rootA];} 
        else {parent[rootB]=rootA;    size[rootA]+=size[rootB];}
        return true;
    }

    public int find(int x, int[] parent) {
        if (parent[x] != x)     parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
