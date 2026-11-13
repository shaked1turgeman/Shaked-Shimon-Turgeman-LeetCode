public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[]{k, 0});
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)    graph[i] = new ArrayList<>();
        for (int[] edge : times)    graph[edge[0]].add(new int[]{edge[1], edge[2]});
        while(!pq.isEmpty()){
            int[] u =pq.poll();
            if (u[1] > dist[u[0]]) continue;
            for (int[] edge : graph[u[0]]) {
                int v = edge[0];
                int weight = edge[1];
                if (dist[u[0]] + weight < dist[v]) {
                    dist[v] = dist[u[0]] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}
