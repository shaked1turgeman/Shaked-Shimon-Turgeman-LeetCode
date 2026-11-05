// Time: O(n * α(n))
// Space: O(n)
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] size = new int[n+1];
        for (int i = 1; i < n+1; i++) {parent[i] = i;  size[i] = 1;}
        for(int i=0; i<edges.length; i++)   
            if(!union(edges[i][0],edges[i][1],parent,size)) return edges[i];
        return new int[0];
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
