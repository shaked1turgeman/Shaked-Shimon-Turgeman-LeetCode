// Time = O(V+E)    ,    Space = O(V+E)
public class CriticalConnectionsInANetwork {
    private int[] tin;
    private int[] low;
    private int timer;
    private List<List<Integer>> bridges;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        tin = new int[n];
        low = new int[n];
        timer = 0;
        bridges = new ArrayList<>();
        Arrays.fill(tin, -1);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)    graph.add(new ArrayList<>());
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1, graph);
        return bridges;
    }

    void dfs(int u, int parent, List<List<Integer>> graph) {
        tin[u] = low[u] = timer++;
        for (int v : graph.get(u)) {
            if (v == parent) continue;
            if (tin[v] == -1) {
                dfs(v,u,graph);
                low[u] = Math.min(low[u], low[v]);   
                if (low[v] > tin[u]) bridges.add(Arrays.asList(u, v));
            } 
            else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
    }
}
