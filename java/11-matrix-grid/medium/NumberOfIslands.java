package medium;

// Time = O(m*n)   ,   Auxiliary Space: O(m*n) worst case due to the recursion stack.
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int counter=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j]=='1')  {counter++;    uniteIsland(grid,i,j);}
            }
        }
        return counter;
    }

    public void uniteIsland(char[][] grid, int row, int col){
        if(row<0||row>=grid.length)  return;
        else if (col<0||col>=grid[row].length)  return;
        else if (grid[row][col]=='0')    return;
        else{
            grid[row][col]='0';
            uniteIsland(grid,row,col+1);
            uniteIsland(grid,row+1,col);
            uniteIsland(grid,row-1,col);
            uniteIsland(grid,row,col-1);
        }
    }
}
