package medium;

import java.util.*;

// Time = O(V+E)   ,   Space = O(V+E)
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue <Integer> q = new ArrayDeque<>();
        List<List<Integer>> graph = new ArrayList<>();
        int remaining = numCourses;
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)    graph.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        for (int i = 0; i < numCourses; i++)    {if (inDegree[i] == 0)  q.offer(i);}
        while(!q.isEmpty()){
            int curr=q.poll();
            remaining--;
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) q.offer(next);
            }
        }
        return remaining == 0;
    }
}
