// Time: O(m * n)   ,   Space: O(m * n) — worst-case recursion stack
/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    var dfs = function(grid, r, c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) return;
        if(grid[r][c] === "0")  return;
        grid[r][c] = "0";
        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);
    };
    let x=0;
    for(let i=0; i<grid.length; i++){
        for(let j=0; j<grid[0].length; j++){
            if(grid[i][j]==="1")    {x++; dfs(grid,i,j);}
        }
    }
    return x;
};
