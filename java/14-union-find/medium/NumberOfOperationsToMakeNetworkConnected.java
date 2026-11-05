// Time: O(n + m * α(n))
// Space: O(n)
public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)  return -1;
        int components = n;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {parent[i] = i;  size[i] = 1;}
        for (int[] edge : connections)                                                       
            {if(union(edge[0], edge[1], parent, size))   components--;}
        return components-1;
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
