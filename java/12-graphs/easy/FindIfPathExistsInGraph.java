package easy;

import java.util.*;

// Time = O(V*E)   ,   Space = O(V*E)
public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for (int i = 0; i < n; i++)    graph.add(new ArrayList<>());
        for(int i=0; i<edges.length; i++){
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(graph, seen, source, destination);
    }

    private boolean dfs(List<List<Integer>> g, boolean[] seen, int curr, int dest) {
        if(curr==dest)  return true;
        seen[curr]=true;
        for(int i : g.get(curr)) {
            if(!seen[i])    {if (dfs(g, seen, i, dest)) return true;}
        }
        return false;        
    }
}
