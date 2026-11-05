// Time: O(m)
// Space: O(1)
// m = equations.length
public class SatisfiabilityOfEqualityEquations {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        int[] size = new int[26];
        for (int i = 0; i < 26; i++) {parent[i] = i;  size[i] = 1;}
        for(int i=0; i<equations.length; i++){
            char a=equations[i].charAt(0), b=equations[i].charAt(3);
            if(equations[i].charAt(1)=='=')     union(a-'a',b-'a',parent,size);
        }
        for(int i=0; i<equations.length; i++){
            char a=equations[i].charAt(0), b=equations[i].charAt(3);
            if(equations[i].charAt(1)=='!'  && find(a-'a', parent) == find(b-'a', parent))
                return false; 
        }
        return true;
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
