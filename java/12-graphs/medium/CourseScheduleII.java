package medium;

import java.util.*;

// Time = O(V+E)   ,   Space = O(V+E)
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Queue <Integer> q = new ArrayDeque<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++)    graph.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prerequisite = edge[1];
            graph.get(prerequisite).add(course);
            inDegree[course]++;
        }
        for (int i = 0; i < numCourses; i++)    {if (inDegree[i] == 0)  q.offer(i);}
        int i=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            res[i]=curr;
            i++;
            for (int next : graph.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) q.offer(next);
            }
        }
        if (i != numCourses)    return new int[0];
        return res;
    }
}
