// Time = O(V + E * α(V))
// Space = O(V)
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)   parent[i] = i;
        int[] size = new int[n];
        for (int i = 0; i < n; i++)    size[i] = 1;
        for (int[] a : edges)   union(a[0],a[1],parent,size);
        return (find(source,parent) == find(destination,parent));
    }

    public void union(int a, int b, int[] parent, int[] size) {
        int rootA = find(a, parent);
        int rootB = find(b, parent);
        if (rootA == rootB) return;
        if (size[rootA] < size[rootB]) {parent[rootA]=rootB;    size[rootB]+=size[rootA];} 
        else {parent[rootB]=rootA;    size[rootA]+=size[rootB];}
    }

    public int find(int x, int[] parent) {
        if (parent[x] != x)     parent[x] = find(parent[x], parent);
        return parent[x];
    }
}
