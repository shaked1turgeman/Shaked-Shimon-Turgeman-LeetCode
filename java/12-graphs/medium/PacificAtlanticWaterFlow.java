package medium;

import java.util.*;

// Time = O(m*n)   ,   Space = O(m*n)
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights[0].length, m=heights.length;
        Set<Integer> pacific = new HashSet<>();
        Set<Integer> atlantic = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        // Pacific — top row
        for (int j = 0; j < n; j++)     dfs(heights, pacific, 0, j, 0, n);

        // Pacific — left column
        for (int i = 0; i < m; i++)     dfs(heights, pacific, i, 0, 0, n);

        // Atlantic — bottom row
        for (int j = 0; j < n; j++)     dfs(heights, atlantic, m - 1, j, 0, n);

        // Atlantic — right column
        for (int i = 0; i < m; i++)     dfs(heights, atlantic, i, n - 1, 0, n);

        for(int i : pacific)    {if(atlantic.contains(i))  res.add(Arrays.asList(i/n,i%n));}
        
        return res;
    }

    public void dfs(int[][] heights, Set<Integer> cells, int i, int j, int prev, int n){
        if(i<0 || i>=heights.length || j<0 || j>=heights[0].length )    return;
        else if (heights[i][j]<prev)    return;
        else if (cells.contains(n*i +j))   return;
        else{
            cells.add(n*i+j);
            dfs(heights,cells,i+1,j,heights[i][j],n);
            dfs(heights,cells,i-1,j,heights[i][j],n);
            dfs(heights,cells,i,j+1,heights[i][j],n);
            dfs(heights,cells,i,j-1,heights[i][j],n);
        }
    }
}
