package medium;

import java.util.Queue;
import java.util.ArrayDeque;

// Time = O(m*n)   ,   Space = O(m*n)
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue <int[]> q = new ArrayDeque<>();
        int fresh=0, minute=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length;j++)
            if(grid[i][j]==2)   q.add(new int[]{i,j});
            else if(grid[i][j]==1)  fresh++;
        }
        while (!q.isEmpty() && fresh>0) {
            int size = q.size();
            minute++;
            while (size > 0) {
                int[] cell = q.poll();
                int[] left = new int[]{cell[0],cell[1]-1};
                int[] right = new int[]{cell[0],cell[1]+1};
                int[] up = new int[]{cell[0]+1,cell[1]};
                int[] down = new int[]{cell[0]-1,cell[1]};
                if(left[0]>=0&&left[0]<grid.length&&left[1]>=0&&left[1]<grid[0].length&&
                    grid[left[0]][left[1]]==1)
                    {q.add(left); grid[left[0]][left[1]]=2; fresh--;}

                if(right[0]>=0&&right[0]<grid.length&&right[1]>=0&&right[1]<grid[0].length&&
                    grid[right[0]][right[1]]==1)
                    {q.add(right);   grid[right[0]][right[1]]=2;  fresh--;}

                if(up[0]>=0&&up[0]<grid.length&&up[1]>=0&&up[1]<grid[0].length&&grid[up[0]][up[1]]==1)
                    {q.add(up);   grid[up[0]][up[1]]=2; fresh--;}

                if(down[0]>=0&&down[0]<grid.length&&down[1]>=0&&down[1]<grid[0].length&&
                    grid[down[0]][down[1]]==1)
                    {q.add(down);   grid[down[0]][down[1]]=2; fresh--;}

                size--;
            }
        }
        if(fresh==0)    return minute;
        return -1;
    }
}
