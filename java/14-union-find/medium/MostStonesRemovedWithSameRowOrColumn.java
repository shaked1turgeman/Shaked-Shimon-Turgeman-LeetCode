// Regular:
// Time: O(n^2 * α(n))
// Space: O(n)

// With Hashing:
// Average Time: O(n * α(n))
// Space: O(n)
public class MostStonesRemovedWithSameRowOrColumn {
    
    public int removeStones(int[][] stones) {
        int n=stones.length;
        if(n==1)  return 0;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {parent[i] = i;  size[i] = 1;}
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] ||stones[i][1] == stones[j][1]) 
                    if(union(i, j, parent, size))   n--;
            }
        }                                                             
        return stones.length-n;
    }

    public int removeStonesWithHashing(int[][] stones) {
        int n=stones.length;
        if(n==1)  return 0;
        HashMap<Integer,Integer> rowMap = new HashMap<>();
        HashMap<Integer,Integer> colMap = new HashMap<>();
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {parent[i] = i;  size[i] = 1;}
        for (int i = 0; i < stones.length; i++) {
            if (rowMap.containsKey(stones[i][0])) {
                if (union(i, rowMap.get(stones[i][0]), parent, size))   n--;
            }
            else {rowMap.put(stones[i][0], i);}
            if (colMap.containsKey(stones[i][1])) {
                if (union(i, colMap.get(stones[i][1]), parent, size))   n--;
            }
            else {colMap.put(stones[i][1], i);}           
        }                                                             
        return stones.length-n;
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
